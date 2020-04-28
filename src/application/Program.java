package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Program {

	public static void main(String[] args)  throws ParseException{

		Scanner input = new Scanner(System.in);

		// C:\tmp\ws-eclipse\JavaCourse50_Map\in.csv

		System.out.print("Enter file full path: ");
		String path = input.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, Integer> map = new TreeMap<>();

			String line = br.readLine();
			while (line != null) {
				String[] stringPart = line.split(",");
				String name = stringPart[0];
				int count = Integer.parseInt(stringPart[1]);

				if (map.containsKey(name)) {
					int votesSoFar = map.get(name);
					map.put(name, count + votesSoFar);
				} else {
					map.put(name, count);
				}

				line = br.readLine();
			}

			for (String candidate : map.keySet()) {
				System.out.println(candidate + ": " + map.get(candidate));
			}

		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("Couldn't load the file: " + e.getMessage());
		}

		input.close();
	}

}
