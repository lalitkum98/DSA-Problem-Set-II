package ProblemSetII;

public class LongestIncreasingSubsequence {

	public void LIS(int[] arr, int[] temp) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && temp[i] < temp[j] + 1) {
					temp[i] = temp[j] + 1;
				}
			}
		}
		int max = 0;
		for (int k = 0; k < temp.length; k++) {
			if (max < temp[k]) {
				max = temp[k];
			}
		}
		System.out.println(" longest Increasing Subsequence :" + max);

	}

	public int recursiveLIS(int[] arr, int len, int max_ref) {
		int value = 0;
		if (len == 1) {
			return 1;
		}

		for (int i = 1; i < len; i++) {
			value = recursiveLIS(arr, i, max_ref);
			if (arr[i] > arr[i - 1] && value < value + 1) {
				value = value + 1;
			}
		}
		return value;
	}

	public static void main(String arg[]) {
		// int arr[] ={1,2,3,0,1,2,3};
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int temp[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		lis.LIS(arr, temp);
		System.out.println(lis.recursiveLIS(arr, arr.length, 0));
	}

}
