package com.capgemini.konferencja;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*; //pobranie bibliotek z pakietu java.util

public class GroupDivider {

	public static List<Person> checkNumber(int number, List<Person> personList) {
		List<Person> newPersonList = new ArrayList();
		return newPersonList;
	}

	public static void main(String[] args) {

		List<Person> personList = FileReader.getPerson("konferencja.csv");

		int personListSize = personList.size();
		boolean isCorrectData = false;

		while (isCorrectData == false) {
			System.out.println("Wprowadź liczbę lub literę:");
			Scanner scanner = new Scanner(System.in);
			String word = scanner.nextLine();

			if (word.matches("[a-zA-Z]")) {
				List<String> newDataList = PersonForLetter.chooseLetter(word, personList);
				isCorrectData = true;
				scanner.close();
			}

			
			else if (!word.matches("0+") && word.matches("[0-9]+")) {
				int result = Integer.parseInt(word);
				if (personListSize % result == 0) {
					List<String> newDataList = PersonForNumber.chooseNumber(word, personList);
					isCorrectData = true; 
					scanner.close();
				}
			}

			
			else {
				System.out.println("Bledne dane. Wprowadz dane jeszcze raz.");
			}
		}
	}
}
