package com.capgemini.konferencja;

import java.util.*;

public class PersonSorter {

	public static List<Person> sortBy(List<Person> personList, String sortBy) {

		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person per1, Person per2) {
				if (sortBy.equals("name")) {
					return per1.getName().compareTo(per2.getName());
				} else {
					return per1.getLastName().compareTo(per2.getLastName());
				}
			}
		});

		return personList;
	}
}
