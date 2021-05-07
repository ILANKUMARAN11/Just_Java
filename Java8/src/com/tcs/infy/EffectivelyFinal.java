package com.tcs.infy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EffectivelyFinal {
	
	int j=0;
	

	public static void main(String[] args) {
		EffectivelyFinal ef=new EffectivelyFinal();
	
		int [] intArr= {12,1,1,1,2,23,45,55,67};
		
		List k=new ArrayList();
		
		Arrays.stream(intArr).map(e->{
			k.add(e);
			 ef.j+=e;
			return ef.j;}).average();
		
		System.out.println(ef.j+"   "+k);
		
		String effectiveFinal = "I am non final local variable";
        Runnable r = () -> {
            System.out.println("Value of effectively variable is : " + effectiveFinal);
        };

        Thread t = new Thread(r);
        t.start();
    }


		
	}


