package ProblemSetII;

public class MaxSubSquareInMatrix {

	public int minOfALL(int a, int b, int c) {
		int min;
		min = (a > b) ? b : a;
		min = (min > c) ? c : min;
		return min;
	}

	public String findMaxSubSquare(int arr[][]) {
		int temparray[][] = new int[arr.length + 1][arr[0].length + 1];
		int max = 0;
		for (int i = 0; i < temparray.length - 1; i++) {
			for (int j = 0; j < temparray[0].length - 1; j++) {
				if (arr[i][j] == 0) {
					temparray[i + 1][j + 1] = 0;
				} else if (arr[i][j] == 1) {
					temparray[i + 1][j + 1] = 1 + minOfALL(temparray[i][j + 1],
							temparray[i + 1][j], temparray[i][j]);
				}
				if (temparray[i + 1][j + 1] > max) {
					max = temparray[i + 1][j + 1];
				}
			}
		}

		return max + "X" + max + " Max Matrix found";
	}

	public static void main(String[] args) {
		int array[][] = { { 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };

		MaxSubSquareInMatrix mss = new MaxSubSquareInMatrix();
		System.out.println(mss.findMaxSubSquare(array));

	}

}
