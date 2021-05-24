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
        DeveloperThread first = new DeveloperThread(1000, latch, 
                                  "WORKER-1");
        DeveloperThread second = new DeveloperThread(2000, latch, 
                                  "WORKER-2");
        DeveloperThread third = new DeveloperThread(3000, latch, 
                                  "WORKER-3");
        DeveloperThread fourth = new DeveloperThread(4000, latch, 
                                  "WORKER-4");
        first.start();
        second.start();
        third.start();
        fourth.start();
        
        QAThread ext=new QAThread(latch, "External_Thread");
        ext.start();
  
        // The main task waits for four threads
        latch.await();
  
        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                           " has finished");
		
		
		

		
	}

}
