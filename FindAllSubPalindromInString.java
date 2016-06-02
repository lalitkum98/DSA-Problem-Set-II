package ProblemSetII;

import java.util.HashSet;
import java.util.Set;

public class FindAllSubPalindromInString {
	// better solution available using suffix
	// tree(http://www.geeksforgeeks.org/suffix-tree-application-5-longest-common-substring-2/)
	public static boolean isPalindrome(String str) {
		if (str.length() > 0) {
			for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
				if (str.charAt(i) == str.charAt(j))
					continue;
				else
					return false;
			}
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabaa";
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				if (isPalindrome(str.substring(i, j))) {
					set.add(str.substring(i, j));
				}
			}
		}
		System.out.println(set);
	}

}
