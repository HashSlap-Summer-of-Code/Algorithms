# Stack Implementation
print("Stack Placeholder")
# Run with: python stack.py
# Stack implementation using a Python list

class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        """Push an item onto the stack."""
        self.items.append(item)

    def pop(self):
        """Pop the top item from the stack."""
        if self.is_empty():
            raise IndexError("Pop from empty stack")
        return self.items.pop()

    def peek(self):
        """Peek at the top item without removing it."""
        if self.is_empty():
            raise IndexError("Peek from empty stack")
        return self.items[-1]

    def is_empty(self):
        """Check if the stack is empty."""
        return len(self.items) == 0

    def size(self):
        """Return the size of the stack."""
        return len(self.items)


# ✅ Demonstration
def main():
    stack = Stack()
    print("🔧 Stack created.")

    print("\n👉 Pushing elements:")
    for elem in [10, 20, 30]:
        print(f"Pushed: {elem}")
        stack.push(elem)

    print(f"\n👀 Peek top: {stack.peek()}")
    print(f"📏 Stack size: {stack.size()}")

    print("\n👉 Popping elements:")
    while not stack.is_empty():
        print(f"Popped: {stack.pop()}")

    print(f"\n📭 Is stack empty? {stack.is_empty()}")

if __name__ == "__main__":
    main()
