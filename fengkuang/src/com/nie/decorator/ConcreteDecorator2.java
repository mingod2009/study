package com.nie.decorator;

public class ConcreteDecorator2 extends Decorator {

	public ConcreteDecorator2(Component comp) {
		super(comp);
	}

	@Override
	public void dothing() {
		//super.dothing();
		doanthor();
	}
	
	private void doanthor() {
		System.out.println("concretedecorator2");
	}

}
