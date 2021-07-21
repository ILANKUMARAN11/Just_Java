package com.ilan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		
		Semaphore semaphore=new Semaphore(2);
		
		ExecutorService executorService=Executors.newFixedThreadPool(50);
		
		for(int i=0;i<100;i++) {
			executorService.execute(new WorkerThread("T"+i,semaphore));
		}
        
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		
		

		
	}

}
