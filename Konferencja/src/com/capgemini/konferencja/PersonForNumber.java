package com.capgemini.konferencja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonForNumber {

	public static List<String> chooseNumber(String word, List<Person> personList) {

		List<Person> sortedListLastName = new ArrayList();
		sortedListLastName = PersonSorter.sortBy(personList, "lastName");
		List<Integer> listAge = new ArrayList();
		listAge = AgeCounter.countAgeList(sortedListLastName);
		List<String> newDataList = new ArrayList();
		newDataList = ListCreator.createList(sortedListLastName, listAge);

		// Zapis do pliku
		try {
			int size = newDataList.size();
			int result = Integer.parseInt(word);
			for (int y = 0; y < (size / result); y++) {
				String nameFile = "C:/Users/jstawiar/Documents/uczestnicy_" + y + ".csv";
				FileSaver saver = new FileSaver(nameFile, true);
				int z = result * (y);
				for (int u = 0; u < result; u++) {
					String dataToList = newDataList.get(z + u);
					saver.saveToFile(dataToList);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Tekst zapisany do pliku");
		return newDataList;
	}
}
