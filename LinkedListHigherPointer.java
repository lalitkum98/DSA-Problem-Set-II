package ProblemSetII; 

import RePracticeAlgo.ReverseLinkedList.Node;

public class LinkedListHigherPointer {
	static class Node {
		int data;
		Node link;
		Node higher;
	}

	public void printNode(Node node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.link;
		}

	}

	public void printHigher(Node node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.higher;
		}

	}

	public Node PointHigher(Node node) {
		Node prev = null;
		Node next = null;
		Node higherprev = null;
		Node starthigher = node;
		Node higherprevprev = null;
		while (node != null && node.link != null) {
			next = node.link;
			while (starthigher != null && starthigher.higher != null
					&& !(starthigher.data > next.data)) {
				if (higherprevprev != null
						&& higherprevprev.data < higherprev.data) {
				} else {
					higherprevprev = higherprev;
				}

				System.out.println(">" + starthigher.data);
				higherprev = starthigher;
				starthigher = starthigher.higher;

			}
			if (starthigher.data > next.data) {
				next.higher = starthigher;
				if (higherprev != null && higherprev.data < next.data) {
					higherprev.higher = next;
					if (higherprevprev != null
							&& higherprevprev.data < higherprev.data) {
						starthigher = higherprevprev;
					} else {
						starthigher = higherprev;
					}

				} else {
					starthigher = next;
				}
			} else {
				starthigher.higher = next;
				if (higherprevprev != null
						&& higherprevprev.data < higherprev.data) {
					starthigher = higherprevprev;
				} else {
					starthigher = higherprev;
				}
			}
			prev = node;
			node = node.link;
		}
		return starthigher;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListHigherPointer high = new LinkedListHigherPointer();
		Node node = new Node();
		node.data = 3;
		node.link = new Node();
		node.link.data = 1;
		node.link.link = new Node();
		node.link.link.data = 2;
		node.link.link.link = new Node();
		node.link.link.link.data = 4;
		node.link.link.link.link = new Node();
		node.link.link.link.link.data = 8;
		node.link.link.link.link.link = new Node();
		node.link.link.link.link.link.data = 9;
		node.link.link.link.link.link.link = new Node();
		node.link.link.link.link.link.link.link.data = 0;
		high.printNode(node);
		node = high.PointHigher(node);
		high.printHigher(node);
	}

}
