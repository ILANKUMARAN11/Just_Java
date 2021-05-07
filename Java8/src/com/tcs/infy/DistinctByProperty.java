package com.tcs.infy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctByProperty {
	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		{
//			list.add(new Book("Core Java", 100));
//			list.add(new Book("Core Java", 200));
//			list.add(new Book("Learning Freemarker", 150));
//			list.add(new Book("Spring MVC", 500));
//			list.add(new Book("Hibernate", 300));
			list.add(new Book(null, 9));
			list.add(new Book("Test", 1));
			list.add(new Book(null, 3));
		}
		
//		System.out.println(list.stream().
//				map(p->{
//				if(p.getName()==null)
//					p.setName("-");
//				return p;
//				}).
//				filter(distinctByKey(Book::getName))
//				.collect(Collectors.toList()).toString());
		
		
		
		System.out.println(">>>>>"+Optional.ofNullable(null).orElse("Test"));
		
}

	private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}


class Book {
	
    private String name;
    private int price;
    
    public Book(String name, int price) {
	this.name = name;
	this.price = price;
    }
    
    public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
	return name;
    }
    public int getPrice() {
	return price;
    }
    @Override
    public boolean equals(final Object obj) {
      if (obj == null) {
         return false;
      }
      final Book book = (Book) obj;
      if (this == book) {
         return true;
      } else {
         return (this.name.equals(book.name) && this.price == book.price);
      }
    }
    @Override
    public int hashCode() {
      int hashno = 7;
      hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
      return hashno;
    }
    
    public String toString() {
    	return "NAME : "+this.name+" PRICE : "+this.price;
    }
} 