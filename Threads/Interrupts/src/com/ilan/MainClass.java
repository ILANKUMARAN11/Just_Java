package com.ilan;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		Worker worker1=new Worker();
		Thread T1=new Thread(worker1,"T1");
		T1.start();
		//Thread.sleep(10);
		T1.interrupt();
		
		Worker worker2=new Worker();
		Thread T2=new Thread(worker2,"T2");
		T2.start();
		
		
		
		Thread.sleep(20000);
		
		System.out.println(Thread.currentThread().getName()+" has completed");

	}

}
