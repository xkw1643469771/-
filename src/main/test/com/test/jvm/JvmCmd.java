package com.test.jvm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JvmCmd{

	public static void main(String[] args) throws Exception {
		InputStream inputStream = Runtime.getRuntime().exec("jps").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		while(true){
			String line = br.readLine();
			if(line == null){
				break;
			}
			System.out.println(line);
		}
	}

}
