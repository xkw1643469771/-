package com.sys.html.po;

import com.sys.html.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class Catalog {

    private List<Item> parent;

    private List<Item> items;

    public List<Item> getParent() {
        return parent;
    }

    public void setParent(List<Item> parent) {
        this.parent = parent;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}