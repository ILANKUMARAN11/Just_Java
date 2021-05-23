package com.tcs;

import java.util.concurrent.locks.ReentrantLock;

class WorkerThread implements Runnable {
	private int delay;
	private ReentrantLock reentrantLock;

	public WorkerThread(int delay, ReentrantLock reentrantLock) {
		this.delay = delay;
		this.reentrantLock = reentrantLock;
	}

	@Override
	public void run() {
		try {
			reentrantLock.lock();
			System.out.println(Thread.currentThread().getName() + " acquired Semaphore");
			Thread.sleep(delay);
			reentrantLock.unlock();

			System.out.println(Thread.currentThread().getName() + " finished");
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
