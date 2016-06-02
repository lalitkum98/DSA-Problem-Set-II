package ProblemSetII;

public class TowerOfHanoi {

	public void pathTOH(int value, char left, char middle, char right) {
		if (value == 0)
			return;
		System.out.println("move from " + left + "to" + right);
		pathTOH(value - 1, left, right, middle);
		System.out.println("move from " + left + "to" + right);
		pathTOH(value - 1, middle, left, right);
		return;
	}

	public static void main(String arg[]) {
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.pathTOH(3, 'L', 'M', 'R');

	}
}
