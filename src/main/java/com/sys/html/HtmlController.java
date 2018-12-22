package com.sys.html;

import com.sys.html.po.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("html")
public class HtmlController {

    @Autowired
    private HtmlService htmlService;

    @GetMapping("test1")
    public List<String> test1(){
        return htmlService.findHtmlFile();
    }

    @GetMapping("catalog")
    public Catalog catalog(String parentPath){
        return htmlService.getCatelogs(parentPath);
    }

}