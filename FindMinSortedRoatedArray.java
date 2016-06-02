package ProblemSetII;

public class FindMinSortedRoatedArray {

	public int bSearch(int arr[], int start, int end) {
		int minValue;
		if (end < start) {
			return arr[start];
		}
		if (start == end) {
			return arr[start];
		}

		int mid = start + ((end - start) / 2);

		if (mid < end && arr[mid] > arr[mid + 1]) {
			return arr[mid + 1];
		}
		if (mid > start && arr[mid - 1] > arr[mid]) {
			return arr[mid];
		}

		if (arr[end] > arr[mid]) {
			minValue = bSearch(arr, start, mid - 1);
		} else {
			minValue = bSearch(arr, mid + 1, end);
		}
		return minValue;
	}

	public static void main(String arg[]) {
		int numbres[] = { 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2 };
		FindMinSortedRoatedArray bs = new FindMinSortedRoatedArray();
		System.out.println(bs.bSearch(numbres, 0, numbres.length - 1));
	}
}
