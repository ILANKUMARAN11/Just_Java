package com.tcs.infy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableIExample implements Callable<String>{

	String text;
	CallableIExample(String text){
	this.text=text;	
	}
	

	@Override
	public String call() throws Exception {
		//System.out.println(Thread.currentThread().getName());
		return this.text;
	}

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		Callable<String> callableExample=new CallableIExample("only callable");
		FutureTask<String> futureTask1 = new FutureTask<String>(callableExample);
		Thread t=new Thread(futureTask1);
		t.start();
		System.out.println(futureTask1.get());
		
		
		//ExecutorService executorService=Executors.newSingleThreadExecutor();
		ExecutorService executorService=Executors.newFixedThreadPool(4);
		List<Future<String>> lstfutureTask=new ArrayList<Future<String>>();
		
		for(int i=0;i<70;i++) {
			callableExample=new CallableIExample("ExecutorService callable"+i);
			Future<String> futureTask2=executorService.submit(callableExample);
			lstfutureTask.add(futureTask2);
		}
		
		lstfutureTask.forEach(e->{
			try {
				System.out.println(e.get());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		
		

	}
	

}
