package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClassDemosApp {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.parse("1999-12-31");
		LocalTime time = LocalTime.parse("20:01:01.973");
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		
		
		
		

	}

}
