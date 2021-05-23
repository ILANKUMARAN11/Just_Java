package com.tcs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		ReentrantLock reentrantLock = new ReentrantLock(true);
		
		ExecutorService executorService=Executors.newFixedThreadPool(50);
		
		for(int i=4000;i>=3500;--i) {
			executorService.execute(new WorkerThread(i,reentrantLock));
		}
        
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		
		

		
	}

}
