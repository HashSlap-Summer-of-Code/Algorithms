# LinkedListAllImpFunctionsInJava

This repository contains a full implementation of a **singly linked list** in Java along with all the essential operations and algorithms. It covers basic operations, searching, sorting, reversing, cycle detection, palindrome checking, and more.

This project is great for **students learning data structures**, for interview preparation, and for anyone wanting a strong grasp of linked list internals.

---

## What is a Linked List?

A **Linked List** is a linear data structure where each element (node) points to the next. Unlike arrays, linked lists do not require contiguous memory and allow dynamic memory allocation.

Each node has:
- `data` — The actual value stored.
- `next` — A reference to the next node.

---

## Node Structure

```java
public static class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

## Fields

```java
public static Node head;
public static Node tail;
public static int size;
```

- `head`: Points to the first node.
- `tail`: Points to the last node.
- `size`: Keeps track of the number of elements.

---

## Basic Operations

### 1. `addFirst(int data)`
**Adds a node to the beginning of the list.**

**How it works:**  
- Create a new node.
- Point its `next` to current `head`.
- Update `head`.
- If the list was empty, update `tail` too.

**Time Complexity:** O(1)

---

### 2. `addLast(int data)`
**Adds a node to the end of the list.**

**How it works:**  
- Create a new node.
- Point current `tail.next` to the new node.
- Update `tail`.
- If the list was empty, update `head`.

**Time Complexity:** O(1)

---

### 3. `addMiddle(int index, int data)`
**Inserts a node at a specific index.**

**How it works:**  
- Traverse to index - 1.
- Insert the new node between two nodes.

**Time Complexity:** O(n)

---

### 4. `printList()`
**Displays the list in a readable format.**

**How it works:**  
- Traverse and print each node till the end.

---

### 5. `removeFirst()`
**Deletes the first node.**

**How it works:**  
- Update `head` to point to the next node.
- If size is 1, reset `head` and `tail`.

**Time Complexity:** O(1)

---

### 6. `removeLast()`
**Deletes the last node.**

**How it works:**  
- Traverse till second last node.
- Make it the new `tail`.

**Time Complexity:** O(n)

---

## Searching

### 7. `searchIterative(int key)`
**Searches for a value by looping through the list.**

**Returns:** Index of the node if found, else -1.

**Time Complexity:** O(n)

---

### 8. `searchRecursive(int key, int idx, Node ptr)`
**Searches using recursion.**

**How it works:**  
- Base case: If node is null, return -1.
- If match found, return index.
- Otherwise, recurse on `next` node.

---

## Reversal and Palindrome

### 9. `reverseLinkedList()`
**Reverses the entire list.**

**How it works:**  
- Traverse while reversing `next` pointers.
- Use three pointers: `prev`, `curr`, `next`.

**Time Complexity:** O(n)

---

### 10. `checkPalindrome()`
**Checks if list is a palindrome.**

**Steps:**
1. Find the middle node.
2. Reverse the second half of the list.
3. Compare first and second halves.

**Time Complexity:** O(n)

---

## Deletion by Position

### 11. `removeNthnodefromLast(int n)`
**Removes the nth node from the end.**

**How it works:**  
- First, calculate total size.
- Then remove node at size - n index.

**Time Complexity:** O(n)

---

## Cycle Detection and Removal

### 12. `isCycleFound()`
**Detects a cycle using Floyd’s Algorithm.**

**How it works:**  
- Use two pointers: `slow` and `fast`.
- If they meet, a cycle exists.

**Time Complexity:** O(n)

---

### 13. `removeCycle()`
**Removes a detected cycle.**

**How it works:**
1. Detect the cycle.
2. Reset `slow` to `head`.
3. Move both pointers until they meet.
4. Set the previous node’s `next` to `null`.

---

## Sorting and Rearranging

### 14. `mergeSort(Node head)`
**Sorts the list using merge sort.**

**Steps:**
1. Find mid.
2. Recursively sort left and right halves.
3. Merge both halves.

**Time Complexity:** O(n log n)

---

### 15. `merge(Node left, Node right)`
**Helper function to merge two sorted lists.**

**How it works:**  
- Use a dummy node to stitch nodes in sorted order.

---

### 16. `zigZagLL(Node head)`
**Rearranges the list in zigzag fashion: first, last, second, second-last, etc.**

**Steps:**
1. Find middle.
2. Reverse the second half.
3. Alternately merge both halves.

---

## Intersection Operations

### 17. `intersectionPoint(Node head1, Node head2)`
**Brute force way to find intersection.**

**How it works:**  
- Compare each node of list1 with every node of list2.

**Time Complexity:** O(n*m)

---

### 18. `getIntersectionNode(Node head1, Node head2)`
**Efficient way to find intersection point.**

**Steps:**
1. Find lengths of both lists.
2. Align their start positions.
3. Traverse together to find matching node.

**Time Complexity:** O(n + m)

---

## Custom Modifications

### 19. `deleteNafterM(int m, int n, Node head)`
**Keeps `m` nodes, then deletes next `n` nodes repeatedly.**

**Example:** For `m=2`, `n=2`, list 1→2→3→4→5→6→7 becomes 1→2→5→6

---

### 20. `swappingNodes(int x, int y, Node head)`
**Swaps two nodes by their data values.**

**How it works:**
- Find both nodes and their previous nodes.
- Reconnect pointers accordingly.

**Does not swap data, swaps nodes.**

---

### 21. `oddEvenLL(Node head)`
**Reorders the list to group even elements first, then odd ones.**

**How it works:**
- Traverse and split into two lists (odd and even).
- Combine both at the end.

---

## Main Method

Sample usage:

```java
ll.addLast(1);
ll.addLast(2);
ll.addLast(3);
ll.addLast(4);
ll.addLast(5);
ll.oddEvenLL(ll.head);
ll.printList();
```

You can test any function by uncommenting its related lines in `main()`.

---

## Final Notes

- This project demonstrates **deep understanding of linked list internals**.
- All functions are written with **clean logic** and **good performance** in mind.
- Ideal for practicing **interview questions** and **data structure foundations**.

---
