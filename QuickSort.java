package ProblemSetII;

public class QuickSort {

	public void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public int calcPivot(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end + 1;
		while (j > i) {
			do {
				i++;
			} while (pivot >= arr[i] && j - 1 > i);
			do {
				j--;
			} while (pivot <= arr[j] && j - 1 > i);
			if (j > i) {
				swap(arr, i, j);
			}

		}
		swap(arr, start, j);
		return j;
	}

	public void quickSort(int[] arr, int start, int end) {
		if (start == end) {
			return;
		} else if (start == (end - 1)) {

			if (arr[start] < arr[end]) {
				return;
			} else {
				swap(arr, start, end);
				return;
			}

		}
		int pivot = calcPivot(arr, start, end);
		quickSort(arr, start, pivot - 1);
		if (!(pivot >= end))
			quickSort(arr, pivot + 1, end);

	}

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static void main(String arg[]) {
		int arr[] = { 65, 70, 75, 80, 85, 60, 55, 50, 45 };
		QuickSort qs = new QuickSort();
		qs.quickSort(arr, 0, 8);
		// System.out.println(qs.calcPivot( 0, 8));
		qs.printArray(arr);

	}

}
