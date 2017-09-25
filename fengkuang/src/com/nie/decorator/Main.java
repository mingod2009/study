package com.nie.decorator;

public class Main {

	public static void main(String[] args) {
		
		Component c = new ConcreteComponent();
		c.dothing();
		
		Component c1 = new ConcreteDecorator1(c);
		c1.dothing();
		
		Component c2 = new ConcreteDecorator2(c1);
		c2.dothing();

	}

}
