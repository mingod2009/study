package com.nie.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		String strEn = "The world is changing, is beautiful world WORLD IS";
		String[] strEnArray = strEn.split("[.,:\\s]");
		
		Map<String, Integer> strNumMap = new HashMap<String, Integer>();
		List<String> result = new ArrayList<String>();
		
		int num = 0;
		// 存放有效单词
		for (String str : strEnArray) {
			String key = str.trim().toUpperCase();
	
			if (key.equals("")) {
				continue;
			}
			// 如果有，计数器加1
			if (strNumMap.containsKey(key)) {
				num = strNumMap.get(key) + 1;
				strNumMap.put(key, num++);
			} else {
				num = 1;
				strNumMap.put(key, num);
				result.add(str);
			}
		}
		// 排序
		Collections.reverse(result);
		// 输出
		for (String str : result) {
			System.out.println(str + " " + strNumMap.get(str.toUpperCase()));
		}

	}
}
