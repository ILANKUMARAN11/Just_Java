package com.ilan;

import java.util.concurrent.CountDownLatch;

class DeveloperThread extends Thread {
	private int delay;
	private CountDownLatch latch;

	public DeveloperThread(int delay, CountDownLatch latch, String threadName) {
		super(threadName);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("Task was started by "+Thread.currentThread().getName());
			Thread.sleep(delay);
			latch.countDown();
			System.out.println("Developer "+Thread.currentThread().getName() + " finished the Task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
