package com.capgemini.konferencja;

import java.util.ArrayList;
import java.util.List;

public class AgeCounter {

	public static List<Integer> countAgeList(List<Person> list) {

		List<Integer> listAge = new ArrayList();
		for (int j = 0; j < list.size(); j++) {
			listAge.add(list.get(j).countAge());
		}

		return listAge;

	}
}
