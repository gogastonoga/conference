package com.capgemini.konferencja;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	public static List<Person> getPerson(String fileName) {

		List<Person> personList = new ArrayList();
		Scanner scanner = null; //

		try {
			scanner = new Scanner(Paths.get(fileName));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] dataPerson = line.split(",");
				personList.add(new Person(dataPerson[0], dataPerson[1], dataPerson[2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (!scanner.equals(null))
				scanner.close();
		}

		return personList;
	}
	
}
