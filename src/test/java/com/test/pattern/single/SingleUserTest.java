package com.test.pattern.single;

import org.junit.Test;

/**
 *
 */
public class SingleUserTest {

    @Test
    public void test1(){
        SingleUserOne.start();
        SingleUserTwo.start();
    }

    @Test
    public void singleUserTwo(){
        SingleUserOne.getUser();
        SingleUserTwo.getUser();
    }

    //利用枚举创建单例
    @Test
    public void test3(){
        SingleUserEnum.test2();
        //SingleUserEnum.READ.abc();
        //SingleUserEnum.READ.abc();
    }

}