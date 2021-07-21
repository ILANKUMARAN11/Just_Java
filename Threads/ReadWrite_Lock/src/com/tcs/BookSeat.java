package com.tcs;

import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class BookSeat implements Runnable {

	WriteLock writeLock;
	String[] seatNumber;

	public BookSeat(WriteLock writeLock, String[] seatNumber) {
		this.writeLock = writeLock;
		this.seatNumber = seatNumber;
	}

	@Override
	public void run() {
		System.out.println("Starting " + Thread.currentThread().getName() + " " + java.time.LocalTime.now());
		try {

			writeLock.lock();

			System.out.println(
					Thread.currentThread().getName() + " is booking the seats" + " " + java.time.LocalTime.now());

			for (int i = 0; i < seatNumber.length; i++) {
				Theater.st.add(Integer.parseInt(seatNumber[i]), Thread.currentThread().getName()+" @ "+java.time.LocalTime.now());
			}
			
			System.out.println(Thread.currentThread().getName() + ">>"+Theater.st.toString());


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
			System.out.println(
					Thread.currentThread().getName() + " has completed Booking" + " " + java.time.LocalTime.now());
		}

	}

}
