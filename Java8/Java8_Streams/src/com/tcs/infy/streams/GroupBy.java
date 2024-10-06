package com.tcs.infy.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tcs.infy.Student;

public class GroupBy {

	public static void main(String[] args) {
		List<Student> stuLst = Arrays.asList(new Student(1, "Ballon", 44, "CANADA", "TN"),
				new Student(1, "Ballon1", 44, "CANADA", "TN"),
				new Student(2, "Basu", 44, "CANADA", "ANDRA"), new Student(3, "BALA", 44, "CANADA", "TN"),
				new Student(4, "BABU", 33, "CANADA","TN"), new Student(5, "SURESH", 0, "CANADA", "TN"));

		Map<String, List<Student>> mpGroup = stuLst.stream().
				collect(Collectors.groupingBy(Student::getCountry));
		System.out.println("1>>>>>>" + mpGroup);
		
//		Map<String, Set<String>> mpGroups = stuLst.stream().
//				collect(Collectors.groupingBy(s -> s.getCountry(), Collectors.mapping(Student::getCountry, Collectors.toSet())));
//		System.out.println("1>>>>>>" + mpGroups);

		Map<String, Long> mpGroup1 = stuLst.stream()
				.collect(Collectors.groupingBy(s -> s.getCountry(), Collectors.counting()));
		System.out.println("2>>>>>>" + mpGroup1);

		Map<Boolean, List<Student>> mp = stuLst.stream()
				.collect(Collectors.partitioningBy(p -> p.getCountry().equals("INDIA")));
		System.out.println("3>>>>>>" + mp);

		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> collectorsCounting = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collectorsCounting);
		
	

		Map<String, Map<String,List<Student>>> ttt = stuLst
				.stream()
				.collect(Collectors.groupingBy(Student::getCountry, Collectors.groupingBy(Student::getState)));
	
		
		stuLst
		.stream()
		.peek(e->System.out.println(">>###"))
		.sorted(Comparator.comparing(Student::getId).reversed());
		System.out.println("Grouping BY"+ttt);
	}

}
