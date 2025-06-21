# 🧱 Stack & Queue – Classic Data Structures

Welcome to the `stacks-queues/` directory!  
This folder features two fundamental linear data structures implemented in two different programming languages for educational and practical use:

- 🐍 `stack.py` – Stack implemented in **Python**
- 🌐 `queue.js` – Queue implemented in **JavaScript**

These implementations follow best practices for clean code, readability, and simplicity, making them ideal for beginner contributors in the [HashSlap Summer of Code (HSSoC)](https://github.com/HashSlap-Summer-of-Code) program.

---

## 📂 File Overview

| File        | Language   | Description                          |
|-------------|------------|--------------------------------------|
| `stack.py`  | Python     | Stack (LIFO) with push, pop, peek    |
| `queue.js`  | JavaScript | Queue (FIFO) with enqueue, dequeue   |

---

## 📚 What You’ll Learn

- ✅ Core operations of stacks and queues (Push/Pop/Enqueue/Dequeue)
- 🧠 Object-oriented class-based implementation in Python and JS
- 🧮 Time and space complexity analysis
- 🛠️ How to run and test these programs using `Node.js` or `Python`

---

## 🐍 Stack – Python Implementation

A **Stack** is a linear data structure that follows the **Last In First Out (LIFO)** principle. Think of it like a stack of books — the last book you place is the first one you remove.

### 🔧 Features:
- `push(item)` – Add element to the top of the stack
- `pop()` – Remove and return the top element
- `peek()` – Return the top element without removing it
- `is_empty()` – Return `True` if stack is empty
- `size()` – Return the number of elements in the stack

### 🧪 Sample Code:
```python
stack = Stack()
stack.push(10)
stack.push(20)
print(stack.peek())    # Output: 20
stack.pop()            # Removes 20
print(stack.size())    # Output: 1
```

---

## 🌐 Queue – JavaScript Implementation

A **Queue** is a linear data structure that follows the **First In First Out (FIFO)** principle — like a queue at a movie ticket counter. The element that enters first is the one to leave first.

### 🔧 Features:
- `enqueue(element)` – Add an element to the end of the queue
- `dequeue()` – Remove the element at the front of the queue
- `peek()` – View the front element without removing it
- `isEmpty()` – Check whether the queue is empty
- `printQueue()` – Display the queue contents from front to back

### 🧪 Sample Code:
```js
const q = new Queue();

q.enqueue(10);
q.enqueue(20);
q.enqueue(30);

console.log(q.peek());        // Output: 10
console.log(q.dequeue());     // Output: 10
console.log(q.peek());        // Output: 20
q.printQueue();               // Output: 20 <- 30

```

---

## 🚀 How to Run the Programs

Make sure you have **Python** and **Node.js** installed on your system.

### 🐍 Running the Stack (Python)

```bash
# Navigate to the folder
cd algo-and-data-structures/stacks-queues/

# Run the Python stack implementation
python stack.py
```

### 🌐 Running the Queue (JavaScript)
```bash
# Navigate to the folder
cd algo-and-data-structures/stacks-queues/

# Run the JavaScript queue implementation
node queue.js
```

---

## 📊 Time and Space Complexity Analysis

Here’s a comparison of the time and space complexities of both data structures implemented in this directory:

| Operation       | Stack (Python) | Queue (JavaScript) | Explanation                                                                 |
|-----------------|----------------|---------------------|-----------------------------------------------------------------------------|
| Push / Enqueue  | O(1)           | O(1)                | Direct array push or append                                                 |
| Pop / Dequeue   | O(1)           | O(n)                | `.pop()` in Python is O(1); `.shift()` in JS reindexes all elements         |
| Peek            | O(1)           | O(1)                | Accessing last/first element directly                                       |
| isEmpty         | O(1)           | O(1)                | Comparing array length or count                                             |
| Size            | O(1)           | O(1)                | Length of array in both languages                                           |
| Space           | O(n)           | O(n)                | Stores all elements internally in array/list                                |

> ⚠️ JavaScript’s `dequeue()` uses `Array.prototype.shift()` which is **O(n)** because it must reindex the entire array.  
> For **constant time dequeue**, use a **linked list** or implement a **two-stack queue**.

---
