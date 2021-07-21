package com.tcs.infy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

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
		
		List<String> l = new LinkedList();
		l.add("Foo");
		String ss[] = l.toArray(new String[l.size()]);
		
		System.out.println(">>>"+ss[0]);
		ListIterator<String> iter = l.listIterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		    //String prev=iter.previous();
		    if(true /*You condition here*/){
		        iter.add("Bah");
		        iter.add("Etc");
		    }
		}
		
		System.out.println(l);


	}

}
