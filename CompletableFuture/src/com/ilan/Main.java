package com.ilan;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Main {

	private static String getOrderTask(Integer i) {
    	return "getOrder" +" "+Thread.currentThread().getName();
    }
	
	private static String enrichOrderTask(String i) {
    	return "enrichOrderTask" +" "+Thread.currentThread().getName();
    }
	
	private static String performPaymentTask(Integer i) {
    	return "performPaymentTask" +" "+Thread.currentThread().getName();
    }
	
	private static String dispatchTask(Integer i) {
    	return "dispatchTask" +" "+Thread.currentThread().getName();
    }
	
	private static String sendEmailTask(Integer i) {
    	return "sendEmailTask" +" "+Thread.currentThread().getName();
    }
	
	
	
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        
        try{

        CompletableFuture.runAsync(()->getOrderTask(1))
                .thenApply(s->enrichOrderTask(s))
                .thenApply(()->getOrderTask)
                .thenApply(()->getOrderTask)
                .thenAccept(()->getOrderTask);

        }catch (Exception e){

        }
    }
}
