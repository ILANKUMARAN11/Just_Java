package com.tcs.infy.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;;

public class MyCustomLamdaExpression {

	interface StringLengthLamda {
		int getLength(String s);
	}

	public void justPrint(MyLamdaPrint myLamdaPrint) {
		myLamdaPrint.printMydata();
	}

	public int justAdd(MyLamdaAdd myLamdaWithArgs) {
		return myLamdaWithArgs.printMydata(11, 12);
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(20);
		list.add(5);
		list.add(30);
		list.add(4);
		list.add(20);
		list.add(60);

		int fistNo = list.get(0);

		boolean flag = true;

		// while(flag && list.size()>1){
		for (int i = 0; list.size() > i; i++) {

			if (i != 0) {
				boolean smaller = list.get(i - 1) > list.get(i);
				if (smaller) {
					list.remove(i);
				}
			}

		}

		System.out.println(list.stream().skip(1) // Stream<Integer>
				.min(Integer::compare) // Optional<Integer>
				.get());
		flag = fistNo > list.stream().skip(1) // Stream<Integer>
				.min(Integer::compare) // Optional<Integer>
				.get() ? false : true;
		// }

		System.out.println(">>>>" + list);

//		MyCustomLamdaExpression myCustomLamda=new MyCustomLamdaExpression();
//		
//		MyLamdaPrint justPrint=()->System.out.println("Hello Ilankumaran");
//		myCustomLamda.justPrint(justPrint);
//		
//		MyLamdaAdd addTwoNo=(int a,int b)->a+b;
//		System.out.println( ">>>>>>>>>>"+myCustomLamda.justAdd((a,b)->a+b) );
//		
//		
//		StringLengthLamda stringLength=p->p.length();
//		System.out.println(stringLength.getLength("ilankumaran"));
//		
//		ExampleFunctional_Interface funInt=(a,b)->a+b;
//		System.out.println("funInt>>>>>>>>>>>"+funInt.addNumbers(12, 13));

//		List<String> lst=new ArrayList<>();
//		lst.add("yLAN");
//		lst.add("KUMARAN");
//		System.out.println(lst.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
//		
//		
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(1, 2);
//
//		map.forEach((k,v)->System.out.println(k+"==="+v));
//		
//		
//		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
//		 
//		
//		Comparator<Integer> reverseComparator = (i1,  i2)->i2.compareTo(i1);
// 
//        List<Integer> sortedList = list.stream()
//                    .sorted(reverseComparator)
//                    .collect(Collectors.toList());
// 
//        System.out.println(sortedList);
//        

	}

}

@FunctionalInterface
interface MyLamdaPrint {

	void printMydata();
}

@FunctionalInterface
interface MyLamdaAdd {

	int printMydata(int a, int b);
}
