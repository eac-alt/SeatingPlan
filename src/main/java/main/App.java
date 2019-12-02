package main;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import seatingplan.ArrayManipulation;
import seatingplan.SeatingPlan;

public class App {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		SeatingPlan seatingplan = new SeatingPlan();
		String[] classNamesArray = { "Elizabeth C", "Luke C", "Chris J", "Zohaib Z", "Alex R", "James B", "Luke P",
				"Luke H", "Adam M", "Alwin T", "Jess L", "Harris H", "Jonathan G", "Liam M", "Matt F", "Rebecca R",
				"Chloe A", "Ewan D", "Euan R", "Anthony W", "Nivs V", "Tigs K", "James K", "Empty Seat" };
		seatingplan.shuffleArray(classNamesArray);
		int numberOfRows = 4;
		int seatsPerRow = 6;
		ArrayManipulation conversion = new ArrayManipulation();
		String[][] seatingArray = conversion.convertTo2D(classNamesArray, numberOfRows, seatsPerRow);

		WriteToExcel writer = new WriteToExcel();
		writer.fileWriter(seatingArray);

	}

}
