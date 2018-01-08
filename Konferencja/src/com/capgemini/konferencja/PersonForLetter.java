package com.capgemini.konferencja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonForLetter {
	public static List<Person> getPersonForLetter(char letter, List<Person> personList) {
		
		List<Person> newPersonList = new ArrayList();
		for (int i=0; i < personList.size() - 1; i++) {
			if (personList.get(i).getLastName().charAt(0) == Character.toUpperCase(letter)) {
				Person newPerson = personList.get(i);		
				newPersonList.add(newPerson);
			}
		}
		return newPersonList;
	}
	
	public static List<String> chooseLetter(String word, List<Person> personList) {

		List<Person> personForLetter = new ArrayList();
		List<Person> sortedListName = new ArrayList();
		personForLetter = getPersonForLetter(word.charAt(0), personList);
		sortedListName = PersonSorter.sortBy(personForLetter, "name");
		List<Integer> listAge = new ArrayList();
		listAge = AgeCounter.countAgeList(sortedListName);
		List<String> newDataList = new ArrayList();
		newDataList = ListCreator.createList(sortedListName, listAge);

		for (int n = 0; n < newDataList.size(); n++) {
			System.out.println(newDataList.get(n) + "\n");
		}

		// Zapis do pliku
		String nameFile = "C:/Users/jstawiar/Documents/uczestnicy_" + word + ".csv";
		try {
			FileSaver saver = new FileSaver(nameFile, true);
			for (int i = 0; i < newDataList.size(); i++)
				saver.saveToFile(newDataList.get(i));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Tekst zapisany do pliku");

		return newDataList;
	}
}


