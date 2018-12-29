package com.test.encode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class EncodeTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                "C:\\Users\\Administrator\\Desktop\\application-dev.properties")));
        while(true){
            String str = br.readLine();
            if(str == null)
                break;
            System.out.println(new String(str.getBytes("UTF-16")));
        }
    }

}