package com.sys.html.po;

import java.util.List;

public class Item {

    private boolean itemIsFolder;
    private String name;
    private String projectPath;

    public Item() {}

    public Item(boolean itemIsFolder, String name, String projectPath) {
        this.itemIsFolder = itemIsFolder;
        this.name = name;
        this.projectPath = projectPath;
    }

    public boolean isItemIsFolder() {
        return itemIsFolder;
    }

    public void setItemIsFolder(boolean itemIsFolder) {
        this.itemIsFolder = itemIsFolder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
}