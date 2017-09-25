package com.nie.test.annotation;

public class Apple extends Fruit {

	@Deprecated
	@Override
	public void info(){
		System.out.println("苹果的info 方法");
	}
}
