package com.nie.command.entity;

public class CeilingFan {

	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	
	public static final int OFF = 0;
	
	private String location;
	private int speed;
	
	public CeilingFan(String location) {
		this.location = location;
		this.speed = OFF;
	}
	public void high() {
		speed = HIGH;
		System.out.println("high");
	}
	public void medium() {
		speed = MEDIUM;
		System.out.println("medium");
	}
	public void low() {
		speed = LOW;
		System.out.println("low");
	}
	public void off() {
		speed = OFF;
		System.out.println("off");
	}
	public int getSpeed() {
		return speed;
	}
	
	
}
