package com.tcs;

import java.util.concurrent.locks.ReentrantLock;

class WorkerThread implements Runnable {
	private String threadName;
	private ReentrantLock reentrantLock;

	public WorkerThread(String threadName, ReentrantLock reentrantLock) {
		this.threadName=threadName;
		this.reentrantLock = reentrantLock;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().setName(this.threadName);
			reentrantLock.lock();
			System.out.println(Thread.currentThread().getName() + " acquired the Lock"+" "+java.time.LocalTime.now());
			
			System.out.println(reentrantLock.getQueueLength());
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			reentrantLock.unlock();
			System.out.println(Thread.currentThread().getName() + " released the Lock"+" "+java.time.LocalTime.now());
			System.out.println("***** END *****");
		}
	}
}
