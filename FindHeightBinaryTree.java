package ProblemSetII;

public class FindHeightBinaryTree {

	static class Tree {
		int value;
		Tree left;
		Tree right;
	}

	public int findHeight(Tree root) {
		int temp1 = 0;
		int temp2 = 0;
		if (root.left == null && root.right == null) {
			return 0;
		}

		if (root.left != null) {
			temp1 = 1 + findHeight(root.left);
		}

		if (root.right != null) {
			temp2 = 1 + findHeight(root.right);
		}

		if (temp1 > temp2) {
			return temp1;
		} else {
			return temp2;
		}
	}

	public static void main(String arg[]) {
		Tree tr = new Tree();
		tr.value = 2;
		tr.left = (new Tree());
		tr.right = (new Tree());
		tr.left.value = 7;
		tr.right.value = 5;
		tr.right.left = (new Tree());
		tr.right.left.value = 8;
		tr.left.right = (new Tree());
		tr.left.right.value = 6;
		tr.left.right.left = (new Tree());
		tr.left.right.right = (new Tree());
		tr.left.right.left.value = 1;
		tr.left.right.right.value = 11;

		FindHeightBinaryTree fhbt = new FindHeightBinaryTree();
		System.out.println(fhbt.findHeight(tr));
	}
}
