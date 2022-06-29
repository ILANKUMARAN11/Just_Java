package com.ilan;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

	private static Supplier<String> getOrderTask(Integer orderNumber) {

		Supplier<String> getOrderTask = () -> {
			// Logic to get the order details for the order number
			String orderDetais = orderNumber + "";
			System.out.println(orderDetais);
			return orderDetais;
		};
		return getOrderTask;
	}

	private static Function<String, String> enrichOrderTask = s -> {
		String enrichOrder = s + " , " + "enrichOrderTask";
		System.out.println(enrichOrder);
		return enrichOrder;
	};

	
	private static Function<String, String> performPaymentTask = s -> {
		String performPayment = s + " , " + "performPaymentTask";
		System.out.println(performPayment);
		return performPayment;
	};

	private static Function<String, String> dispatchTasks = s -> {
		String dispatch = s + " , " + "dispatchTasks";
		System.out.println(dispatch);
		return dispatch;
	};

	private static Consumer<String> sendEmailTask = s -> {
		String sendEmail = s + " , " + "sendEmailTask";
		System.out.println(sendEmail);
	};

	public static void main(String[] args) {
		
		try {

			CompletableFuture.supplyAsync(getOrderTask(12))
			.thenApply(enrichOrderTask)
			.thenApply(performPaymentTask)
			.thenApply(dispatchTasks)
			.thenAccept(sendEmailTask);
			
			CompletableFuture.supplyAsync(getOrderTask(12))
			.thenApplyAsync(enrichOrderTask)
			.thenApplyAsync(performPaymentTask)
			.thenApplyAsync(dispatchTasks)
			.thenAcceptAsync(sendEmailTask);
			
			ExecutorService workStealingPool = Executors.newWorkStealingPool();
			
			int availableCore=Runtime.getRuntime().availableProcessors();
			ExecutorService executorService=Executors.newFixedThreadPool(availableCore);
			ExecutorService cpuBound=Executors.newFixedThreadPool(200);
			
			CompletableFuture.supplyAsync(getOrderTask(12),executorService)
			.thenApplyAsync(enrichOrderTask,cpuBound)
			.thenApplyAsync(performPaymentTask,cpuBound)
			.thenApply(dispatchTasks)
			.thenAccept(sendEmailTask);
			

		} catch (Exception e) {

		}
	}
}
