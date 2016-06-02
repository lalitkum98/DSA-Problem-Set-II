package ProblemSetII;

public class HeapSort {
	static class Heap {
		int value;
		Heap left;
		Heap right;

	}

	public Heap createHeap(Heap root, int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (root.value == 0) {
				root.value = arr[i];
			} else if (root.left == null || root.right == null) {
				Heap child = new Heap();
				child.value = arr[i];
				if (root.left == null) {
					root.left = child;
				} else if (root.right == null) {
					root.right = child;
					root = root.left;

				}

			}
		}
		return root;
	}

	public void hepifiy(Heap root) {
		if (root.left == null || root.right == null) {
			return;
		}
		hepifiy(root.left);
		hepifiy(root.right);
		if (root.value < root.left.value) {
			int temp = root.value;
			root.value = root.left.value;
			root.left.value = temp;
		}
		if (root.value < root.right.value) {
			int temp = root.value;
			root.value = root.right.value;
			root.right.value = temp;
		}
	}

	public void printTree(Heap root) {
		if (root == null) {
			return;
		}
		System.out.println(root.value);
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String arg[]) {
		int arr[] = { 3, 5, 2, 1, 4, 2, 8 };
		HeapSort hs = new HeapSort();
		Heap root = new Heap();
		hs.createHeap(root, arr);
		hs.printTree(root);
		hs.hepifiy(root);

	}
}
