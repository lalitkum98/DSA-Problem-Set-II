package ProblemSetII;

public class ConvertBinaryArrayToAnotherSwapCount {

	/**
	 * Find minimum number of swaps to convert one binary array to another.
	 * Note: It is always possible. You are given two integer array having only
	 * 0's and 1's. Find minimum number of swaps to convert array1 to array2.
	 * NOTE: You can only swap adjacent elements.
	 */
	public int[] swap(int i, int j, int array[]) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}

	public int swapCount(int array1[], int array2[]) {
		int swapcount = 0;
		int array1Strat = 0;
		int array2Start = 0;

		while (array2Start < array2.length - 1) {

			if (array1[array1Strat] == array2[array2Start]) {
				array1Strat++;
				array2Start++;
			} else {
				if (array1[array1Strat] != array1[array1Strat + 1]) {
					array1 = swap(array1Strat, array1Strat + 1, array1);
					swapcount++;
					array1Strat++;
					array2Start++;
				} else {

					while (array1Strat < array1.length - 1 && array1Strat >= 0
							&& array1Strat >= array2Start) {
						if (array1[array1Strat] == array1[array1Strat + 1]) {
							array1Strat++;
						} else if (array1Strat >= array2Start) {
							array1 = swap(array1Strat, array1Strat + 1, array1);
							swapcount++;
							array1Strat--;
						}

					}
					array1Strat = array2Start;
				}
			}
		}
		return swapcount;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = { 1, 1, 0, 0, 0, 0 };
		int array2[] = { 0, 0, 0, 0, 1, 1 };
		ConvertBinaryArrayToAnotherSwapCount sc = new ConvertBinaryArrayToAnotherSwapCount();
		System.out.println(sc.swapCount(array1, array2));

	}

}
