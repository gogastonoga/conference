package com.capgemini.konferencja;

import java.util.ArrayList;
import java.util.List;

public class ListCreator {

	public static List<String> createList(List<Person> listPerson, List<Integer> listAge) {
	
		List<String> newDataList = new ArrayList();
		
		for (int m = 0; m < listPerson.size(); m++){
			StringBuilder builder = new StringBuilder("");
			builder.append(listPerson.get(m).getName() + "," + listPerson.get(m).getLastName() + "," + listAge.get(m));
			String newData = builder.toString();
			newDataList.add(newData);
			}
		
		return newDataList;
	}
	
}
