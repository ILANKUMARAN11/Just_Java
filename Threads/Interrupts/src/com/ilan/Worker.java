package com.ilan;

public class Worker implements Runnable {

	@Override
	public void run() {
		System.out.println("Started Task by " + Thread.currentThread().getName());
		for (int i = 0; i <= 1000; i++) {
			//processThisNumber(i);

			if (Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName() + " Stopping the Task");
				
				//Thread.interrupted();
				return;
			}else {
				processThisNumber(i);
			}
		}
	}

	public void processThisNumber(int i) {
		System.out.println(Thread.currentThread().getName() + ">>>>>" + i);
	}

}
