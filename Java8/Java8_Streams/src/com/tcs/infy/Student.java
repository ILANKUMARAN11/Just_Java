package com.tcs.infy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {

	private Double id;

	private String name;

	private int mark;

	private String country;
	
	private String state;

	public Student(double id, String name, int mark, String country, String state) {
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.country = country;
		this.state = state;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String toString() {
		return "ID : "+this.id + " , Name : " + this.name + " , Mark : " + this.mark+ " , Country : " + this.country+ " , state : " + this.state;
	}
	
	

	

	public static void main(String ilan[]) {

		List<Student> stuLst = Arrays.asList(new Student(9, "Ballon", 44, "US", "A"), new Student(8, "Basu", 44, "CANADA", "A"),
				new Student(1, "BALA", 44, "CANADA", "A"), new Student(5, "BABU", 33, "CANADA", "B"), new Student(3, "SARA", 22, "CANADA", "B"));

		// 1st way of sorting
		Comparator<Student> c = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getId() == o2.getId()) {
					return 0;
				} else if (o1.getId() > o2.getId()) {
					return 1;
				} else {
					return -1;
				}
			}
		};

		System.out.println(stuLst.stream().filter(p -> p.getName().startsWith("B")).sorted(c)
				.collect(Collectors.toList()).toString());

		// 2nd way of sorting
		Comparator<Student> c1 = (o1, o2) -> {
			if (o1.getId() == o2.getId()) {
				return 0;
			} else if (o1.getId() > o2.getId()) {
				return 1;
			} else {
				return -1;
			}
		};

		System.out.println(stuLst.stream().filter(p -> p.getName().startsWith("B")).sorted(c1.reversed())
				.collect(Collectors.toList()).toString());

		// 3rd way of sorting
		System.out.println(">>>>"+stuLst.stream().filter(p -> p.getName().startsWith("B"))
				.sorted(Comparator.comparingDouble(Student::getId).thenComparing(Student::getMark)).skip(1).limit(3).collect(Collectors.toList())
				.toString());

		Stream<String> stream = Stream.of("tone", "two", "three", "four");

		boolean match = stream.allMatch(s -> s.length() == 4);

		System.out.println(match); // true
		
		System.out.println(stuLst
				.stream()
				.collect(Collectors.groupingBy(Student::getCountry,Collectors.groupingBy(Student::getState))));

		
		System.out.println(8%5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
