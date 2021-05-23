package com.ilan;

import java.util.concurrent.CountDownLatch;

class WorkerThread extends Thread {
	private int delay;
	private CountDownLatch latch;

	public WorkerThread(int delay, CountDownLatch latch, String threadName) {
		super(threadName);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
