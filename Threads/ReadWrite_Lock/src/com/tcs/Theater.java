package com.tcs;

import java.util.ArrayList;

public class Theater {
	
	public static ArrayList<String> st=new ArrayList<>();
	
	static {
		
		for(int i=0;i<10;i++)
		{
			st.add("FREE "+i);
		}
		
	}

}
