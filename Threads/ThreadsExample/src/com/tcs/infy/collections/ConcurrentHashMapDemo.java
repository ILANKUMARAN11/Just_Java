package com.tcs.infy.collections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

static ConcurrentHashMap<Integer,String> l=new ConcurrentHashMap<Integer,String>(); 
    
    static {
    	l.put(1,"A"); 
    	l.put(2,"B");
    }
    
    
    
  
    public void run() 
    { 
      
        try{ 
        	System.out.println(Thread.currentThread().getName());
        	l.put(3,"C"); 
            Thread.sleep(1000); 
            // Child thread trying to add new element in the object
            System.out.println(l.put(3,"C")+">>>>>>>"+l.get(1));
        } 
        catch(Exception e) 
        { 
            System.out.println("Child Thread going to add element"); 
        } 
    } 
  
    public static void main(String[] args) throws InterruptedException 
    { 
    	System.out.println(Thread.currentThread().getName());
    	
    	HashMapDemo t=new HashMapDemo(); 
        t.start(); 
        
        for (Object o : l.entrySet())  
        { 
            Object s=o; 
            System.out.println(s); 
            l.put(12, "RRR");
            Thread.sleep(1000); 
        } 
          
        
        System.out.println(l); 
    } 

}
