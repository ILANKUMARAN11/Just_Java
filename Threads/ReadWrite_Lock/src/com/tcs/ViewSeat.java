package com.tcs;

import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ViewSeat implements Runnable {

	ReadLock readLock;

	public ViewSeat(ReadLock readLock) {
		this.readLock = readLock;
	}

	@Override
	public void run() {
		System.out.println("Starting " + Thread.currentThread().getName() + " " + java.time.LocalTime.now());
		try {
			
			readLock.lock();

			System.out.println(
					Thread.currentThread().getName() + " is viewing the Free seats" + " " + java.time.LocalTime.now());
			
			Theater.st.forEach(seats->System.out.println(Thread.currentThread().getName()+ " "+seats+ " " + java.time.LocalTime.now()));


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
			System.out.println(Thread.currentThread().getName() + " has completed the view" + " " + java.time.LocalTime.now());
		}
	}

}
