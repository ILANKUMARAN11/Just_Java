package com.tcs.infy;

public class TestThread extends Thread {
	
	@Override
	public void run() {
		
		for(int i=0;i<5000;i++) {
			//System.out.println(Thread.currentThread().getName()+"  "+i);
		}
			
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		TestThread t1=new TestThread();
		t1.setName("T1");
		
		TestThread t2=new TestThread();
		t2.setName("T2");
		
		long startTime = System.nanoTime();


		t1.join();
		t1.start();
		
		t2.start();
		long endTime = System.nanoTime();


		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds  : " + timeElapsed);

		System.out.println("Execution time in milliseconds : " + 
								timeElapsed / 1000000);
		
		Thread t=new Thread(()->{});
	

	}

}
