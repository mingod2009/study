package com.nie.test.shutdownhook;

public class TestShutdownHook {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("thread1....");
			}
		};
		
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("thread2....");
			}
		};
		
		Thread shutdownThread = new Thread() {
			public void run() {
				System.out.println("shutdown thread...");
			}
		};
		
		Runtime.getRuntime().addShutdownHook(shutdownThread);
		
		thread1.start();
		thread2.start();
	}
}
