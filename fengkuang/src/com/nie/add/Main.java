package com.nie.add;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String inputStr = "hello world 2300 at 2010, 9# Beijing 5";
		
		String[] strEnArray = inputStr.split("[\n\t\r.,;:!?(){}\\s]");
		
		Pattern p = Pattern.compile("^\\d+$");
		
		int result = 0;
		for (String str : strEnArray) {
			if (str.trim().equals("")) {
				continue;
			}
			Matcher m = p.matcher(str);
			if (m.matches()) {
				result += Integer.valueOf(str).intValue();
			}
		}
		System.out.println(result);
		
	}
}
