package ProblemSetII;

import java.util.ArrayList;
import java.util.HashMap;

public class LexicographicRankOfAString {
	public int permute(char[] num, String word) {
		int rank = 0;
		HashMap<String, Integer> ranks = new HashMap<String, Integer>();
		ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
		permute(num, 0, result);
		for (int i = 0; i < result.size(); i++) {
			ranks.put(result.get(i).toString(), i + 1);
		}
		rank = ranks.get(word);
		System.out.println(ranks);
		return rank;
	}

	void permute(char[] num, int start, ArrayList<ArrayList<Character>> result) {
		if (start >= num.length) {
			ArrayList<Character> item = convertArrayToList(num);
			result.add(item);
		}

		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}

	private ArrayList<Character> convertArrayToList(char[] num) {
		ArrayList<Character> item = new ArrayList<Character>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}

	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String arg[]) {
		char arr[] = { 'a', 'b', 'c', 'd' };
		String word = "[c, b, a, d]";
		LexicographicRankOfAString apc = new LexicographicRankOfAString();
		System.out.println(apc.permute(arr, word));
	}

}