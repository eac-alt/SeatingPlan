package seatingplan;

public class ArrayManipulation {
	public String[][] convertTo2D(String[] oneDArray, int rowsInRoom, int seatsPerRow) {
		
		int count = 0;
		String[][] seatingArray = new String[rowsInRoom][seatsPerRow];
		for (int row = 0; row < seatingArray.length; row++) {
			for (int person = 0; person < seatingArray[row].length; person++) {
				seatingArray[row][person] = oneDArray[count];
				count++;
			}
		}
		return seatingArray;
	}
}
