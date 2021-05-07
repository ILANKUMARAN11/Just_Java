package com.tcs.infy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {
		
		String []arr= {"Test"};
		
		List<String> str=Arrays.asList(arr);
		
		Optional.ofNullable(str).orElseGet(ArrayList::new).addAll(str);

	}

}
