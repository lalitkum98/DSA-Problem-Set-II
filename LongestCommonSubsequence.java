package ProblemSetII;

public class LongestCommonSubsequence {
	// using dynamic programming
	public void LCS(String string1, String string2, int[][] track) {
		for (int i = 0; i < string1.length() + 1; i++) {
			for (int j = 0; j < string2.length() + 1; j++) {

				if (i == 0 || j == 0) {
					track[i][j] = 0;
				} else {

					if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
						track[i][j] = track[i - 1][j - 1] + 1;
					} else {
						if (track[i - 1][j] > track[i][j - 1]) {
							track[i][j] = track[i - 1][j];
						} else {
							track[i][j] = track[i][j - 1];
						}
					}
				}

			}
		}

		System.out.println(track[string1.length()][string2.length()]);
	}

	public int rcursiveLCS(String string1, String string2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		} else {

			if (string1.charAt(m - 1) == string2.charAt(n - 1)) {
				// System.out.println(string1.charAt(m-1));
				return 1 + rcursiveLCS(string1, string2, m - 1, n - 1);

			} else {
				int max1 = rcursiveLCS(string1, string2, m - 1, n);
				int max2 = rcursiveLCS(string1, string2, m, n - 1);
				if (max1 > max2) {
					return max1;
				} else {
					return max2;
				}
			}

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String string1 ="HLM";
		// String string2 ="HM";
		String string1 = "CHIMPANZEE";
		String string2 = "HUMAN";
		int track[][] = new int[string1.length() + 1][string2.length() + 1];
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.LCS(string1, string2, track);
		int m = string1.length();
		int n = string2.length();
		System.out.println(lcs.rcursiveLCS(string1, string2, m, n));
	}

}
