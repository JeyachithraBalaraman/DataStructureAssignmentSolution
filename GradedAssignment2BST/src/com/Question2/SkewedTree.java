package com.Question2;
//Jeyachithra Balaraman - Convert Binary Search tree to Skewed Tree
class Node {
	int key;
	Node left, right;
	// to allocate new node
	Node(int data) {
		key = data;
		left = right = null;

	}
}

class SkewedTree {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	// Function to convert BST to Skewed tree
	static void RightSkew(Node root) {

		// Base Case
		if (root == null) {
			return;
		}

		RightSkew(root.left);
		Node rightNode = root.right;

		// Condition to check if the root Node
		// of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		RightSkew(rightNode);
	}

	// Function to traverse the right
	// skewed tree using recursion
	static void traverse(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		traverse(root.right);
	}

	public static void main(String[] args) {

		// 50
		// / \
		// 30 60
		// / /
		// 10 55
		SkewedTree.node = new Node(50);
		SkewedTree.node.left = new Node(30);
		SkewedTree.node.right = new Node(60);
		SkewedTree.node.left.left = new Node(10);
		SkewedTree.node.right.left = new Node(55);
		RightSkew(node);

		// 10
		// \
		// 30
		// \
		// 50
		// \
		// 55
		// \
		// 60

		System.out.println("Skewed Tree");
		traverse(headNode);
		System.out.println();

	}

}
