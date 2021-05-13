package com.tcs.infy.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminnalOperations {

	public static void main(String ilan[]) {

		List<Student> stuLst = Arrays.asList(new Student(1, "Ballon", 44, "CANADA"),
				new Student(2, "Basu", 44, "CANADA"), new Student(3, "BALA", 44, "CANADA"),
				new Student(4, "BABU", 33, "CANADA"), new Student(5, "SURESH", 0, "CANADA"));

		
		
		boolean anyMatches = stuLst.stream().anyMatch(s -> s.getName().length() == 4);

		System.out.println("anyMatch()===>>" + anyMatches);

		boolean allMatches = stuLst.stream().allMatch(s -> s.getId() <= 5);

		System.out.println("allMatch()===>>" + allMatches); // true

		boolean noneMatches = stuLst.stream().noneMatch(s -> s.getId() == 7);

		System.out.println("noneMatch()===>>" + noneMatches); // true

		Optional<Student> minMark = stuLst.stream()
				.min((i, j) -> Integer.valueOf(i.getMark()).compareTo(Integer.valueOf(j.getMark())));

		System.out.println("min() Mark===>>" + minMark);

		Optional<Student> maxMark = stuLst.stream().max(Comparator.comparingInt(Student::getMark));

		System.out.println("max() Mark===>>" + maxMark);

		System.out.println("count()===>>" + stuLst.stream().count());
		System.out.println("findAny()===>>" + stuLst.stream().findAny().toString());
		System.out.println("findFirst()===>>" + stuLst.stream().findFirst().toString());
		System.out.println("collect()===>>" + stuLst.stream().collect(Collectors.toList()));

	}

}
