package com.nie.test.countdown;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownDemo {

	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) throws InterruptedException {
	
		CountDownLatch latch = new CountDownLatch(2);
		
		Worker worker1 = new Worker("worker 1", 5000, latch);
		Worker worker2 = new Worker("worker 2", 8000, latch);
		
		worker1.start();
		worker2.start();
		latch.await();
		System.out.println("all work done at : " + sdf.format(new Date()));
	}
	
	static class Worker extends Thread {
		String workerName;
		int workTime;
		
		CountDownLatch latch;
		
		public Worker(String workerName, int workTime, CountDownLatch latch) {
			this.workerName = workerName;
			this.workTime = workTime;
			this.latch = latch;
		}
		
		public void run() {
			System.out.println("Worker : " + workerName + " do work begin at :" + sdf.format(new Date()));
			doWork();
			System.out.println("worker : " + workerName + " do work complete at :" + sdf.format(new Date()));
			latch.countDown();
		}
		private void doWork() {
			try {
				Thread.sleep(workTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

