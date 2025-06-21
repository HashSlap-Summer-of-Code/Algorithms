// Binary Tree Implementation

/**
 * Node class represents each node in the binary tree.
 * Each node has:
 *  - data: the value it holds
 *  - left: reference to the left child
 *  - right: reference to the right child
 */
class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

/**
 * BinaryTree class manages the structure and logic of the tree.
 * Supports:
 *  - insert: adds new nodes in level-order (breadth-first)
 *  - inOrder: prints elements in left-root-right order
 */
class BinaryTree {
  constructor() {
    this.root = null;
  }

  /**
   * Insert a new node into the tree using level-order traversal.
   * Ensures a complete binary tree structure.
   * 
   * @param {*} data - The value to insert
   */
  insert(data) {
    const newNode = new Node(data);

    // If tree is empty, make the new node the root
    if (!this.root) {
      this.root = newNode;
      return;
    }

    // Use a queue for level-order traversal to find insertion point
    const queue = [this.root];

    while (queue.length > 0) {
      const current = queue.shift();

      if (!current.left) {
        current.left = newNode;
        return;
      } else {
        queue.push(current.left);
      }

      if (!current.right) {
        current.right = newNode;
        return;
      } else {
        queue.push(current.right);
      }
    }
  }

  /**
   * Perform in-order traversal (Left → Root → Right)
   * @param {Node} node - Starting node (defaults to root)
   */
  inOrder(node = this.root) {
    if (!node) return;

    this.inOrder(node.left);
    console.log(node.data);
    this.inOrder(node.right);
  }
}

// ✅ Demonstration

// Initialize tree
const tree = new BinaryTree();

// Insert elements into the tree
[1, 2, 3, 4, 5].forEach(value => tree.insert(value));

// Output in-order traversal
console.log("🧭 In-order Traversal:");
tree.inOrder();

/*
Expected Output:
🧭 In-order Traversal:
4
2
5
1
3
*/

// ✅ Run using: node binary-tree.js

// 📊 Complexity:
// Insert: O(n) (due to level-order traversal)
// In-order Traversal: O(n) time, O(h) space (recursion stack)
