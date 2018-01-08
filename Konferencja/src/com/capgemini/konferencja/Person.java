package com.capgemini.konferencja;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Person {

	private String name;
	private String lastName;
	private String date;

	public Person(String name, String lastName, String date) {
		this.name = name;
		this.lastName = lastName;
		this.date = date;
	}

	public int countAge() {

		String[] newDate = date.split("-");

		GregorianCalendar dateOfBirth = new GregorianCalendar(Integer.parseInt(newDate[0]),
				Integer.parseInt(newDate[1]), Integer.parseInt(newDate[2]));
		int dayB = dateOfBirth.get(Calendar.DAY_OF_MONTH);
		int monthB = dateOfBirth.get(Calendar.MONTH);
		int yearB = dateOfBirth.get(Calendar.YEAR);

		GregorianCalendar now = new GregorianCalendar();
		int today = now.get(Calendar.DAY_OF_MONTH);
		int month = now.get(Calendar.MONTH) + 1; // numeracja miesiecy od 0 do
													// 11
		int year = now.get(Calendar.YEAR);

		int age = 0;

		if (month > monthB) {
			age = year - yearB;
		} else if (month < monthB) {
			age = year - yearB - 1;
		}

		else {
			if (month == monthB && dayB > today) {
				age = year - yearB - 1;
			}
			if (month == monthB && today > dayB) {
				age = year - yearB;
			}
		}

		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Name= " + name + ", lastName=" + lastName + ", date=" + date + "\n";
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

