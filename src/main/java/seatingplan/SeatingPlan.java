package seatingplan;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SeatingPlan {


	public void shuffleArray(String[] seat) {
	Random rnd = ThreadLocalRandom.current(); 
	for(int i = seat.length - 1;i>0;i--)
	{
		int index = rnd.nextInt(i + 1);
	
		String person1 = seat[index];
		seat[index] = seat[i];
		seat[i] = person1;
	}
}
}