package com.ilan;

import java.util.concurrent.CountDownLatch;

public class QAThread extends Thread {
	private CountDownLatch latch;

	public QAThread(CountDownLatch latch, String threadName) {
		super(threadName);
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("QA tester "+Thread.currentThread().getName()+" started testing the Task");
			latch.await();
			System.out.println("QA tester "+Thread.currentThread().getName() + " finished testing");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}