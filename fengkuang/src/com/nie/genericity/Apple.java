package com.nie.genericity;

public class Apple<b> {

	private b info;

	public Apple() {

	}
	public Apple(b info) {
		this.info  = info;
	}
	public b getInfo() {
		return info;
	}
	public void setInfo(b info) {
		this.info = info;
	}

	public static void main(String[] args) {
		Apple<String> a1 = new Apple<>("apple");
		System.out.println(a1.getInfo());

		Apple<Double> a2 = new Apple<>(5.5);
		System.out.println(a2.getInfo());
	}

}
