package ProblemSetII;

import java.util.ArrayList;
import java.util.List;

public class CoinChanging {
	

	public int min(int a, int b) {
		return a < b ? a : b;
	}

	public String findMinChangeRequired(int[] coins, int changeRequired) {
		int temp[][] = new int[coins.length][changeRequired + 1];

		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < changeRequired + 1; j++) {
				if (j > coins[i] && i <= 0) {
					temp[i][j] = 1 + temp[i][j - coins[i]];
				} else if (j > coins[i]) {
					temp[i][j] = min(temp[i - 1][j], 1 + temp[i][j - coins[i]]);
				} else {
					temp[i][j] = 1;
				}
			}

		}
		return "Minnum coin required :"
				+ temp[coins.length - 1][changeRequired];
	}

	public void printCoins(int[] coins, int changeRequired) {
		ArrayList<Integer> coinsss = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> coinCobination = new ArrayList<ArrayList<Integer>>();
		int i = coins.length - 1;
		int j = changeRequired;
		while (j != 0 || i > 0) {
			if (temp[i][j] < temp[i - 1][j]) {
				j = j - coins[i];
				coinsss.add(coins[i]);
			} else {
				i--;
			}

		}
		coinCobination.add(coinsss);
		System.out.println(coinCobination);
	}

	public String numberOfWays(int[] coins, int changeRequired) {
		int temp[][] = new int[coins.length][changeRequired + 1];
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < changeRequired + 1; j++) {
				temp[i][0] = 1;
			}
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < changeRequired + 1; j++) {
				if (i <= 0) {
					temp[i][j] = j % coins[i] == 0 ? 1 : 0;
				} else if (j >= coins[i]) {
					temp[i][j] = (temp[i - 1][j] + temp[i][j - coins[i]]);
				} else {
					temp[i][j] = 1;
				}
			}

		}
		return "Maximum ways to get change  :"
				+ temp[coins.length - 1][changeRequired];
	}

	private void printActualSolution(List<Integer> result, int total,
			int coins[], int pos) {
		if (total == 0) {
			for (int r : result) {
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for (int i = pos; i < coins.length; i++) {
			if (total >= coins[i]) {
				result.add(coins[i]);
				printActualSolution(result, total - coins[i], coins, i);
				result.remove(result.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// int coins[] ={2,4,5}; // should be in increasing order
		// int changeRequired = 9;
		int coins[] = { 1, 2, 3 }; // should be in increasing order
		int changeRequired = 4;
		CoinChanging cc = new CoinChanging();
		System.out.println(cc.findMinChangeRequired(coins, changeRequired));
		//cc.printCoins(coins, changeRequired);
		System.out.println(cc.numberOfWays(coins, changeRequired));
		List<Integer> result = new ArrayList<Integer>();
		cc.printActualSolution(result, changeRequired, coins, 0);

	}

}
