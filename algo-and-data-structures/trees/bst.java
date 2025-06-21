// Binary Search Tree (BST) Implementation

/**
 * Node class represents each node in the BST.
 * Each node has:
 * - int data: value of the node
 * - Node left: reference to the left child
 * - Node right: reference to the right child
 */
class Node {
    int data;
    Node left, right;

    Node(int value) {
        this.data = value;
        left = right = null;
    }
}

/**
 * BST class encapsulates all operations on the Binary Search Tree.
 * Supports:
 * - insert: inserts values recursively maintaining BST properties
 * - inOrder: traverses the tree in ascending order (Left → Root → Right)
 */
public class BST {
    Node root;

    // Constructor initializes an empty tree
    BST() {
        root = null;
    }

    // Public method to insert value
    void insert(int data) {
        root = insertRecursive(root, data);
    }

    /**
     * Recursive insert logic.
     * Places smaller values to the left, larger to the right.
     */
    Node insertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }
        // If value already exists, do not insert duplicates
        return current;
    }

    /**
     * In-order traversal: Left → Root → Right
     * Prints nodes in ascending order
     */
    void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    // Main method to test BST
    public static void main(String[] args) {
        BST tree = new BST();

        // ✅ Insert sample data into BST
        int[] values = { 50, 30, 70, 20, 40, 60, 80 };
        for (int val : values) {
            tree.insert(val);
        }

        // ✅ In-order Traversal
        System.out.println("🔍 In-order Traversal of BST:");
        tree.inOrderTraversal(tree.root);

        // ✅ Expected Output: 20 30 40 50 60 70 80
    }
}

/*
 * 📌 How to Compile & Run:
 * 
 * javac bst.java && java BST
 * 
 * 📊 Time Complexity:
 * - Insert: O(log n) average, O(n) worst (unbalanced)
 * - In-order Traversal: O(n)
 * - Space: O(n) for recursion stack
 * 
 */
