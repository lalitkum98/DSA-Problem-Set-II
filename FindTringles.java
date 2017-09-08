package ProblemSetII;

// find height of the triangle in the matrix if exists
public class FindTringles {
	public int findTringles(String tringleMatrix[]) {
		int value = 0, height = 0;
		int max = 0;
		for (int i = 0; i < tringleMatrix.length; i++) {
			for (int j = 0; j < tringleMatrix[0].length(); j++) {
				value = findTringlesheight(tringleMatrix,
						tringleMatrix[i].charAt(j), i, j, height);
				if (value > max)
					max = value;
			}
		}
		return max;
	}

	public int findTringlesheight(String tringleMatrix[], char value, int i,
			int j, int height) {
		if (i < 0 || j < 0 || j >= tringleMatrix[0].length()
				|| i >= tringleMatrix.length) {
			return 0;
		}
		if (value != tringleMatrix[i].charAt(j)) {
			return 0;
		}
		int height1 = findTringlesheight(tringleMatrix, value, i + 1, j, height);
		int height2 = findTringlesheight(tringleMatrix, value, i + 1, j - 1,height);
		int height3 = findTringlesheight(tringleMatrix, value, i + 1, j + 1,height);
		height = Math.min(height3, Math.min(height1, height2));

		return height + 1;
	}

	public static void main(String arg[]) {
		FindTringles fi = new FindTringles();
		String tringleMatrix[] = { "abcxabx", "bcbaxax", "xxacaca" };
		System.out.println(fi.findTringles(tringleMatrix));
	}

}
