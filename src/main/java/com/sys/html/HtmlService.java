package com.sys.html;

import com.sys.base.SignCons;
import com.sys.html.po.Catalog;
import com.sys.html.po.Item;
import com.sys.util.AssertUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Service
public class HtmlService {

    private File baseFile;
    private File staticFile;

    public HtmlService(){
        baseFile = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        staticFile = new File(baseFile, "static");
    }

    public List<String> findHtmlFile() {
        File staticHtml = new File(baseFile, "static/html");
        if (!staticHtml.exists()) {
            return null;
        }
        LinkedList<File> list = new LinkedList<>();
        List<String> paths = new ArrayList<>();
        list.add(staticHtml);
        while (!list.isEmpty()) {
            File file = list.pop();
            if (file.isDirectory()) {
                for(File childFile : file.listFiles()){
                    list.add(childFile);
                }
            } else if (file.toString().endsWith(".html")) {
                String path = file.getAbsolutePath();
                path = path.substring(staticHtml.getAbsolutePath().length());
                path = path.replace("\\","/");
                paths.add(path);
            }
        }
        return paths;
    }

    public Catalog getCatelogs(String parentPath) {
        File htmlFile = new File(staticFile, "html");
        File file = new File(staticFile, parentPath);
        AssertUtils.isTree(file.exists(), "文件不存在!");
        AssertUtils.isTree(file.isDirectory(), "不是一个文件夹!");
        Catalog catalog = new Catalog();
        catalog.setParent(new ArrayList<>());
        String hPath = getPathBaseStatic(htmlFile.getAbsolutePath());
        catalog.getParent().add(new Item(true, "根目录", hPath));
        while(true){
            String pPath = getPathBaseStatic(file.getAbsolutePath());
            if(pPath.equals(hPath))
                break;
            Item item = new Item();
            item.setItemIsFolder(true);
            item.setName(file.getName());
            item.setProjectPath(pPath);
            catalog.getParent().add(item);
            file = file.getParentFile();
        }
        catalog.setItems(getItemBaseHtmlPath(parentPath));
        return catalog;
    }

    public List<Item> getItemBaseHtmlPath(String parentPath) {
        File currFile = new File(staticFile, parentPath);
        AssertUtils.isTree(currFile.isDirectory(), "不是一个文件夹!");
        File[] files = currFile.listFiles();
        List<Item> items = new ArrayList<>();
        for(File file : files){
            if(!file.getName().endsWith(".html") && !file.isDirectory())
                continue;
            if(file.getAbsolutePath().endsWith("static\\html\\index.html"))
                continue;
            String path = file.getAbsolutePath();
            Item item = new Item();
            item.setItemIsFolder(file.isDirectory());
            int baseLength = staticFile.getAbsolutePath().length();
            item.setProjectPath(getPathBaseStatic(path));
            if(file.isDirectory())
                item.setName("<" + file.getName() + ">");
            else
                item.setName(file.getName().substring(0, file.getName().length() - 5));
            items.add(item);
        }
        return items;
    }

    public String getPathBaseStatic(String path){
        int baseLength = staticFile.getAbsolutePath().length();
        return path.substring(baseLength).replace(SignCons.SING_SLASH, SignCons.SING_BACKSLASH);
    }

}