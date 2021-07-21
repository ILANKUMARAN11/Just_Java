package com.tcs;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
		ReadLock readLock = reentrantReadWriteLock.readLock();
		WriteLock writeLock = reentrantReadWriteLock.writeLock();
		
		//Creating the threads for reading

//		for (int i = 1; i <= Runtime.getRuntime().availableProcessors(); i++) {
//			Thread t = new Thread(new ViewSeat(readLock), "T" + i);
//			t.start();
//		}
		
		//Creating the threads for Writing

		String booking[][] = { { "0", "1" }, { "5" }, { "7" }, { "9" } };
		for (int i = 1; i <= Runtime.getRuntime().availableProcessors(); i++) {
			Thread t = new Thread(new BookSeat(writeLock, booking[i - 1]), "T" + i);
			t.start();
		}

	}

}
