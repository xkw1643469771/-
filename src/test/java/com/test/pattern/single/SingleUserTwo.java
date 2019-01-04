package com.test.pattern.single;

/**
 *
 */
public class SingleUserTwo {

    private static class CreateUser{
        static User user = new User(SingleUserTwo.class);
    }

    private SingleUserTwo(){}

    public static User getUser(){
        return CreateUser.user;
    }

    public static void start(){
        System.out.println("SingleUserTwo");
    }
}