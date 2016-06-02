package ProblemSetII;

public class DeepestPitHole {
	/*
	 * Doesn't seem too hard. One loop is enough. You store two triplets, one as
	 * the best, and one as a working set.
	 * 
	 * 1) Mark the first element as P in the working set 2) Read an item while Q
	 * is not marked If lesser than the previous, keep going: 2) If greater or
	 * equal than the previous, mark the previous as Q If you run out of numbers
	 * then it is no real pit, goto 6) 3) Read an item while R is not marked If
	 * greater than the previous, keep going: 3) If lesser or equal than the
	 * previous, mark the one before it as R If you run out of numbers, mark the
	 * last one as R, goto 4) 4) Decide if this is better than the best, it's
	 * quite simple 5) Mark the previous element as P in the working set, set Q
	 * = R = null, go to 2) if you have any item left 6) If the best is 0 deep
	 * or null, then no pit found
	 */

	public int findDeepestPitHole() {

		int A[] = { 0, 1, 3, -2, 0, 1, 0, -3, 2, 3 };
		int depth = 0;

		int P = 0, Q = -1, R = -1;

		for (int i = 1; i < A.length; i++) {
			if (Q < 0 && A[i] >= A[i - 1])
				Q = i - 1;

			if ((Q >= 0 && R < 0) && (A[i] <= A[i - 1] || i + 1 == A.length)) {
				if (A[i] <= A[i - 1])
					R = i - 1;
				else
					R = i;
				System.out.println(P + "  " + Q + "  " + R);
				depth = Math.max(depth, Math.min(A[P] - A[Q], A[R] - A[Q]));
				System.out.println(depth);
				P = i - 1;
				Q = R = -1;
			}
		}
		if (depth == 0)
			depth = -1;
		return depth;

	}

	public static void main(String[] args) {
		int array[] = { 0, 1, -3, 2, 5, 2, -2 };
		DeepestPitHole ss = new DeepestPitHole();
		System.out.println(ss.findDeepestPitHole());
	}

}
