package com.tcs.infy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBy {

	public static void main(String[] args) {
		List<Student> stuLst = Arrays.asList(new Student(1, "ARUN", 44, "CHICAGO"),
				new Student(2, "SARAVANAN", 44, "CANADA"), new Student(3, "ILAN", 44, "CANADA"),
				new Student(4, "UMA", 33, "INDIA"), new Student(5, "SHILPA", 0, "INDIA"));

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
		
	

	}

}
