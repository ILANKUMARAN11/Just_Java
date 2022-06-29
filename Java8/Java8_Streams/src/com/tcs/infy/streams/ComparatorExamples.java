package com.tcs.infy.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ComparatorExamples {

	public static void main(String[] args) {
		
		Set<Number> s = new HashSet<>();
		
		//s.add(1);
		s.add(new Integer(1));
		s.add(new Integer(1));
		
		System.out.println();
		
		System.out.println(s);
			
		List<Student> stuLst = Arrays.asList(
				new Student(1, "ARUN", 44, "CHICAGO"),
				new Student(2, "SARAVANAN", 44, "CANADA"), 
				new Student(3, "ILAN", 44, "CANADA"),
				new Student(4, "UMA", 33, "INDIA"), 
				new Student(5, "SHILPA", 0, "INDIA"));
		
		Comparator<Student> c1 = new Comparator<Student>() {
			public int compare(Student st1, Student st2) {
			if(st1.getId()==st2.getId()) {
				return 0;
			} else if(st1.getId()>st2.getId()) {
				return 1;
			}else {
				return -1;
			}}
		};
		
		
		
		System.out.println(stuLst.stream()
							.sorted(Comparator.comparingDouble(Student::getId).reversed().thenComparing(Student::getName))
							.collect(Collectors.toList()));
		
		
		System.out.println(stuLst.stream()
				.sorted((st1,st2)->{
					if(st1.getId()==st2.getId()) {
						return 0;
					} else if(st1.getId()>st2.getId()) {
						return 1;
					}else {
						return -1;
					}
				})
				//.sorted(c1.reversed())
				.collect(Collectors.toList()));
		
	}

}
