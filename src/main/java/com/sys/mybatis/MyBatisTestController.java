package com.sys.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisTestController {

    @Autowired
    private MyBatisTestService myBatisTestService;

    @GetMapping("test1")
    public void test1(){
        myBatisTestService.test1();
    }

}