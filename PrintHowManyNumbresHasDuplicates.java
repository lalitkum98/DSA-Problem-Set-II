package ProblemSetII;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrintHowManyNumbresHasDuplicates {


	public int countDuplicates(int[] numbers) {
		int count = 1;
		HashMap<Integer, Integer> numberOfOccurrences = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (numberOfOccurrences.containsKey(numbers[i])) {

				numberOfOccurrences.put(numbers[i],
						(numberOfOccurrences.get(numbers[i])) + 1);

			} else {
				numberOfOccurrences.put(numbers[i], count);
				// System.out.println(maxnum.get(arr[i]));
			}
			// System.out.println(count);

		}
		int dublicates = 0;

		Iterator it = numberOfOccurrences.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry fetchDublicates = (Map.Entry) it.next();
			int value = (int) fetchDublicates.getValue();
			if (value > 1) {
				dublicates++;
			}

		}
		// System.out.println(dublicate);

		return dublicates;
	}


	
	public static void main(String arg[]){
		PrintHowManyNumbresHasDuplicates ss = new PrintHowManyNumbresHasDuplicates();
		int arr[] ={1,3,1,4,5,6,3,2};
		System.out.println(ss.countDuplicates(arr));
	}
}
