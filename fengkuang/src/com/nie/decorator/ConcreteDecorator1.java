package com.nie.decorator;

public class ConcreteDecorator1 extends Decorator {

	public ConcreteDecorator1(Component comp) {
		super(comp);
	}

	@Override
	public void dothing() {
		//super.dothing();
		doanthoer();
	}

	private void doanthoer() {
		System.out.println("concretedecorator1");
	}
}
