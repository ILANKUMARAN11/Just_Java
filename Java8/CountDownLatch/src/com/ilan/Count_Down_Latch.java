package com.ilan;

import java.util.concurrent.CountDownLatch;

public class Count_Down_Latch {

	public static void main(String[] args) throws InterruptedException{
		
		CountDownLatch cdL=new CountDownLatch(3);
		
		// Let us create task that is going to 
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);
  
        // Let us create four worker 
        // threads and start them.
        WorkerThread first = new WorkerThread(1000, latch, 
                                  "WORKER-1");
        WorkerThread second = new WorkerThread(2000, latch, 
                                  "WORKER-2");
        WorkerThread third = new WorkerThread(3000, latch, 
                                  "WORKER-3");
        WorkerThread fourth = new WorkerThread(4000, latch, 
                                  "WORKER-4");
        first.start();
        second.start();
        third.start();
        fourth.start();
        
        ExternalThread ext=new ExternalThread(latch, "External_Thread");
        ext.start();
  
        // The main task waits for four threads
        latch.await();
  
        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                           " has finished");
		
		
		

		
	}

}
