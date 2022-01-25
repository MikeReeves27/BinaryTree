import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

	Node root;

	public BinaryTree() {
		root = null;
	}

	// Breadth traversal
	public void breadthTraversal(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			node = q.remove();
			System.out.print(node.data + " ");

			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	// Depth traversal: Pre-order
	public void preOrderDepthTraversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderDepthTraversal(node.left);
		preOrderDepthTraversal(node.right);
	}

	// Depth traversal: In-order
	public void inOrderDepthTraversal(Node node) {
		if (node == null) {
			return;
		}
		inOrderDepthTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderDepthTraversal(node.right);
	}

	// Depth traversal: Post-order
	public void postOrderDepthTraversal(Node node) {
		if (node == null) {
			return;
		}
		postOrderDepthTraversal(node.left);
		postOrderDepthTraversal(node.right);
		System.out.print(node.data + " ");
	}

	// Find the total sum of nodes in the tree
	public int findSum(Node node, int i) {
		if (node == null) {
			return 0;
		}
		System.out.println("Level " + i + ": " + node.data);
		i++;
		return node.data + findSum(node.left, i) + findSum(node.right, i);
	}

	// Find the max depth of a tree
	public int findDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = findDepth(node.left);
		int rightDepth = findDepth(node.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);

		System.out.println();
		System.out.println("Breadth traversal:");
		tree.breadthTraversal(tree.root);
		System.out.println();
		System.out.println();
		System.out.println("Depth traversal. Pre-order:");
		tree.preOrderDepthTraversal(tree.root);
		System.out.println();
		System.out.println();
		System.out.println("Depth traversal. In-order:");
		tree.inOrderDepthTraversal(tree.root);
		System.out.println();
		System.out.println();
		System.out.println("Depth traversal. Post-order:");
		tree.postOrderDepthTraversal(tree.root);
		System.out.println();
		System.out.println();
		System.out.println("Max depth of tree:");
		System.out.println(tree.findDepth(tree.root));
		System.out.println();

	}

}

class Node {

	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}