package ProblemSetII;

public class BinarySearch {

	public boolean bSearch(int arr[], int start, int end, int searchValue) {
		boolean ret;
		if (start == end && arr[start] == searchValue) {
			return true;
		} else if (start == end && arr[start] != searchValue) {
			return false;
		}
		int mid = start + ((end - start) / 2);
		if (arr[mid] == searchValue) {
			return true;
		} else if (searchValue < arr[mid]) {
			ret = bSearch(arr, start, mid - 1, searchValue);

		} else {
			ret = bSearch(arr, mid + 1, end, searchValue);
		}
		return ret;
	}

	public static void main(String arg[]) {
		int numbers[] = { 1, 2, 3, 5, 6, 7 };
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.bSearch(numbers, 0, numbers.length, 0));

	}
}
