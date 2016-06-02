package ProblemSetII;

public class MaxSubSquareWithSideX {

	static class Cordinate {
		int vert;
		int horz;

		public Cordinate(int vert, int horz) {
			this.vert = vert;
			this.horz = horz;
		}

	}

	public String findMaxSubSquare(int array[][]) {
		int subSquare = 0;
		int minValue = 0;
		int minIndexI = 0;
		int minIndexJ = 0;
		Cordinate cordinates[][] = new Cordinate[array.length][array[0].length];

		for (int i = 0; i < cordinates.length; i++) {
			for (int j = 0; j < cordinates[0].length; j++) {
				if (array[i][j] == 0) {
					cordinates[i][j] = new Cordinate(0, 0);
				} else if (i <= 0 && j <= 0) {
					cordinates[i][j] = new Cordinate(1, 1);
				} else if (i <= 0) {
					cordinates[i][j] = new Cordinate(
							cordinates[i][j - 1].vert + 1, 1);
				} else if (j <= 0) {
					cordinates[i][j] = new Cordinate(1,
							cordinates[i - 1][j].horz + 1);
				} else {
					cordinates[i][j] = new Cordinate(
							cordinates[i][j - 1].vert + 1,
							cordinates[i - 1][j].horz + 1);
				}
			}
		}

		for (int i = cordinates.length - 1; i >= 0; i--) {
			for (int j = cordinates[0].length - 1; j >= 0; j--) {
				int min = Math
						.min(cordinates[i][j].vert, cordinates[i][j].horz);
				minIndexI = i - (min - 1);
				minIndexJ = j - (min - 1);
				minValue = min;
				if (subSquare < minValue) {
					while (minIndexI < i || minIndexJ < j) {
						if (cordinates[minIndexI][j].vert >= minValue
								&& cordinates[i][minIndexJ].horz >= minValue) {
							subSquare = minValue;
							minIndexI = minIndexI + 1;
							minIndexJ = minIndexJ + 1;
						} else {
							minIndexI = minIndexI + 1;
							minIndexJ = minIndexJ + 1;
							minValue = minValue - 1;
						}
					}
				}
			}
		}
		return "Max sub Square found " + subSquare;
	}

	public static void main(String[] args) {
		int array[][] = { { 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1 } };
		MaxSubSquareWithSideX mssx = new MaxSubSquareWithSideX();
		System.out.println(mssx.findMaxSubSquare(array));

	}

}
