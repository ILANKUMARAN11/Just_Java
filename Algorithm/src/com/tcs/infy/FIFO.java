package com.tcs.infy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FIFO {
	
	static void queue_add(Queue<Integer>  queue) 
    { 
        for (int i = 0; i < 5; i++) { 
        	queue.add(i); 
        } 
    } 
	
	static void queue_print(Queue<Integer>  queue) 
    { 
        System.out.println("Printing Queue");
        Iterator<Integer> it=queue.iterator(); 
        
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
    } 

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>(); 
		  
		queue_add(queue);
		queue_print(queue);
		
		Random random = new Random();

		
		for(int i =0; i<5; i++){
		      int randomInteger = random.nextInt();
		      System.out.println("Random Integer in Java: " + randomInteger);
		 }

	}

}
