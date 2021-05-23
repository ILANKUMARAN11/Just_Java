package com.ilan;

import java.util.concurrent.CountDownLatch;

public class ExternalThread extends Thread {
	private CountDownLatch latch;

	public ExternalThread(CountDownLatch latch, String threadName) {
		super(threadName);
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}