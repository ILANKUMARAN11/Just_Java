package com.ilan;

import java.util.concurrent.Semaphore;

class WorkerThread implements Runnable {
	private final String threadName;
	private Semaphore semaphore;

	public WorkerThread(String threadName, Semaphore semaphore) {
		this.threadName = threadName;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(this.threadName);
		System.out.println("Starting " + Thread.currentThread().getName() + " " + java.time.LocalTime.now());
		try {
			// First, get a permit.
			System.out.println(
					Thread.currentThread().getName() + " is waiting for a permit." + " " + java.time.LocalTime.now());

			// acquiring the lock
			semaphore.acquire();

			System.out.println(Thread.currentThread().getName() + " gets a permit." + " " + java.time.LocalTime.now());

			// Now, accessing the shared resource.
			// other waiting threads will wait, until this
			// thread release the lock

			Thread.sleep(5000);

//			if("pool-1-thread-1".equalsIgnoreCase(Thread.currentThread().getName())) {
//				semaphore.acquireUninterruptibly(2);
//				System.out.println(Thread.currentThread().getName() + " acquired Semaphore");
//				Thread.sleep(delay);
//				semaphore.release(2);
//				System.out.println(Thread.currentThread().getName() + " finished");
//			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println(Thread.currentThread().getName() + " finished" + " " + java.time.LocalTime.now());
		}
	}
}
