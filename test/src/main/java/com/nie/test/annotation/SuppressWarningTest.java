package com.nie.test.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings(value="unchecked")
public class SuppressWarningTest {

	public static void main(String[] args) {
		List<String> myList = new ArrayList();
		if(myList.isEmpty()) {
			System.out.println("empty");
		}
		
		List list = new ArrayList<Integer>();
		list.add(20);
		
		List<String> list2 = list;
		
		//System.out.println(list2.get(0));
		
		myList.add("a");
		faultyMethod(myList);
	}
	@SafeVarargs
	public static void faultyMethod(List<String>...listStrArray) {
		List[] listArray = listStrArray;
		
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		
		listArray[0] = myList;
		
		String s = listStrArray[0].get(0);
		
	}
}
