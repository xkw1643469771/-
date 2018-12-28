package com.test.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Test {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[1234567890]+");
        Matcher matcher = pattern.matcher("123-456-789");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

}