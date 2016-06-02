package ProblemSetII;

public class EggDrop {
	// Normal approach
	public int eggDrop(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= floors; i++) {
			int value = 1 + Math.max(eggDrop(eggs - 1, i - 1),
					eggDrop(eggs, floors - i));

			if (value < min) {
				min = value;
			}

		}

		return min;
	}

	// using DP approach
	public String findMinFloors(int eggs, int floors) {
		int[][] temp = new int[eggs + 1][floors + 1];
		int value = 0;
		for (int j = 1; j < floors + 1; j++) {
			temp[1][j] = j;
		}

		for (int i = 2; i < eggs + 1; i++) {

			for (int j = 1; j < floors + 1; j++) {
				temp[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k <= j; k++) {
					if (i > j) {
						temp[i][j] = temp[i - 1][j];
					} else {
						value = 1 + Math
								.max(temp[i - 1][k - 1], temp[i][j - k]);
						if (value < temp[i][j]) {
							temp[i][j] = value;
						}

					}
				}
			}
		}

		return "min nos of steps :" + temp[eggs][floors];
	}

	public static void main(String[] args) {
		EggDrop ed = new EggDrop();
		System.out.println(ed.eggDrop(2, 8));
		System.out.println(ed.findMinFloors(2, 8));

	}

}
