package ProblemSetII;

public class MergSort {

	public int[] mergSort(int arr[], int start, int end) {
		if (start == end) {
			return arr;
		} else if (start == end - 1) {
			if (arr[start] > arr[end]) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				return arr;
			} else {
				return arr;
			}
		}

		int mid = start + (end - start) / 2;
		int arr1[] = mergSort(arr, start, mid);
		int arr2[] = mergSort(arr, mid + 1, end);
		int mergarr[] = new int[arr.length];
		int k = start;
		int i = start;
		int j = mid + 1;
		while (i <= mid && j <= end) {
			if (arr1[i] < arr2[j]) {
				mergarr[k] = arr1[i];
				i++;
			} else {
				mergarr[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			mergarr[k] = arr1[i];
			k++;
			i++;
		}
		while (j <= end) {
			mergarr[k] = arr2[j];
			k++;
			j++;
		}
		return mergarr;
	}

	public static void main(String arg[]) {
		int arr[] = { 3, 5, 2, 1, 4, 2, 8 };
		MergSort ms = new MergSort();
		int mergarr[] = ms.mergSort(arr, 0, arr.length - 1);
		for (int i = 0; i < mergarr.length; i++) {
			System.out.println(mergarr[i]);
		}
	}
}
