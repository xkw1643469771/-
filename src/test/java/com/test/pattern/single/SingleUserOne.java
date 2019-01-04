package com.test.pattern.single;

/**
 *
 */
public class SingleUserOne {

    private static User user = new User(SingleUserOne.class);

    private SingleUserOne(){}

    public static User getUser(){
        return user;
    }

    public static void start(){
        System.out.println("SingleUserOne");
    }

}