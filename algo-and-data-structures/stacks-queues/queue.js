// 🔧 Queue Implementation in JavaScript
// ✅ Methods: enqueue, dequeue, peek
// 📦 Usage: node queue.js

class Queue {
  constructor() {
    this.items = [];
  }

  // Add element to the queue (back)
  enqueue(element) {
    this.items.push(element);
  }

  // Remove element from the queue (front)
  dequeue() {
    if (this.isEmpty()) {
      return 'Queue is empty';
    }
    return this.items.shift();
  }

  // Peek at the front element
  peek() {
    if (this.isEmpty()) {
      return 'Queue is empty';
    }
    return this.items[0];
  }

  // Check if the queue is empty
  isEmpty() {
    return this.items.length === 0;
  }

  // Print the queue contents
  printQueue() {
    console.log(this.items.join(' <- '));
  }
}

// ✅ Example usage
const q = new Queue();

q.enqueue(10);
q.enqueue(20);
q.enqueue(30);

console.log('Front element:', q.peek());       // 10
q.printQueue();                                // 10 <- 20 <- 30

console.log('Dequeued:', q.dequeue());         // 10
console.log('Front element after dequeue:', q.peek());  // 20
q.printQueue();                                // 20 <- 30

// 📌 Run using: node queue.js

// 🔁 Time Complexity:
// enqueue: O(1), dequeue: O(n) due to shift(), peek: O(1)
// Space Complexity: O(n)
