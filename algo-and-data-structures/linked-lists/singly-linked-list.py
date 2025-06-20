# Singly Linked List Implementation 
print("Singly Linked List ")
# Run with: python singly-linked-list.py
# Implementation of a Singly Linked List in Python

class Node:
    """A node in a singly linked list"""
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    """A singly linked list"""
    def __init__(self):
        self.head = None

    def append(self, data):
        """Add a node to the end of the list"""
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        
        current = self.head
        while current.next:
            current = current.next
        current.next = new_node

    def display(self):
        """Print the linked list"""
        current = self.head
        if not current:
            print("List is empty.")
            return
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

    def delete(self, key):
        """Delete the first node with the given data"""
        current = self.head
        prev = None

        while current and current.data != key:
            prev = current
            current = current.next

        if current is None:
            print(f"{key} not found in the list.")
            return

        if prev is None:
            self.head = current.next
        else:
            prev.next = current.next
        print(f"Deleted: {key}")

# ✅ Demonstration
def main():
    print("🔧 Creating Singly Linked List...")
    sll = SinglyLinkedList()

    print("\n👉 Appending elements:")
    for value in [10, 20, 30, 40]:
        print(f"Appending: {value}")
        sll.append(value)

    print("\n📋 Displaying list:")
    sll.display()

    print("\n❌ Deleting 20...")
    sll.delete(20)
    sll.display()

    print("\n❌ Trying to delete 99...")
    sll.delete(99)

if __name__ == "__main__":
    main()
