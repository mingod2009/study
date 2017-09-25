package com.nie.decorator;

public abstract class Decorator implements Component{

	private Component comp;
	public Decorator(Component comp) {
		this.comp = comp;
	}
	@Override
	public void dothing() {
		this.comp.dothing();
		
	}

	
}
