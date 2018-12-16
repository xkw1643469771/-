package com.test.jvm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JVMTest {

	public static void main(String[] args) throws Exception {
		while(true){
			int pid = getPidByJps("Test1");
			System.out.println(getByJmap(pid, "com.sys"));
			Thread.sleep(1000);
		}
	}

	// 获取堆大小
	static int getByJmap(int pid, String pkg) throws Exception {
		InputStream is = Runtime.getRuntime().exec("jmap -histo " + pid)
				.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = null;
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			if (line.contains(pkg))
				System.out.println(line);
			str = line;
		}
		if(str == null)
			return -1;
		return Integer.parseInt(strToArr(str, 3)[2]);
	}

	// 根据Jps拿到对应名称的Pid
	static int getPidByJps(String name) throws Exception {
		InputStream is = Runtime.getRuntime().exec("jps").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			String[] arr = strToArr(line, 2);
			if (arr[1].equals(name)) {
				return Integer.parseInt(arr[0]);
			}
		}
		return -1;
	}

	// 将字符串转成没有null的数组
	static String[] strToArr(String str, int num) {
		str = str.concat(" ");
		String[] ss = new String[num];
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (idx >= ss.length) {
				break;
			} else if (c != ' ') {
				sb.append(c);
				flag = true;
			} else if (flag && sb.length() > 0 && idx < ss.length) {
				ss[idx++] = sb.toString();
				sb.delete(0, sb.length());
				flag = false;
			}
		}
		for (int i = idx; i < ss.length; i++) {
			ss[i] = "";
		}
		return ss;
	}

}
