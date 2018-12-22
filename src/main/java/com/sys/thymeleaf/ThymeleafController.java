package com.sys.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class ThymeleafController{

    // 测试异步调用方法
    @GetMapping("")
    public String index(){
        return "index";
    }

}