package com.sys.util;

public class AssertUtils {

    private AssertUtils(){}

    public static void isTree(boolean isTure, String message){
        if(!isTure)
            throw new RuntimeException(message);
    }

    public static void main(String[] args) {
    }

}