public class LinkedListAllImpFunctionsInJava {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }  
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            //newNode.next = null;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        //newNode.next = null;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node ptr = head;
        while (ptr.next != null) {
            System.out.print(ptr.data+"->");
            ptr = ptr.next; 
        }
        System.out.print(ptr.data+"->null");
        System.out.println();
    }

    public void addMiddle(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (temp.next != null && i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public int searchIterative(int key) {   //O(n)
        Node ptr = head;
        int posi = 0;
        while (ptr != null && ptr.data != key) {
            posi++;
            ptr = ptr.next;
        }
        return (ptr == null) ? -1: posi;
    }

    public int searchRecursive(int key, int idx, Node ptr) {
        if (ptr == null) {
            return -1;
        }
        else if(ptr.data == key) {
            return idx;
        }
        return searchRecursive(key, idx+1, ptr.next);
    }

    public void reverseLinkedList() {   //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeNthnodefromLast(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;   //removeFirst
            return;
        }
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    //Slow-fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my midNode
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        //step 1 : To find mid
        Node midNode = findMid(head); 

        //step 2 : Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //right half head
        Node left = head;

        //step 3 : check left half and right half for palindrome
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycleFound() { //Floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        //find meeting point
        if (isCycle) {
            slow = head;
            Node prev = null;
            while (slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            //remove cycle last.next = null
            prev.next = null;
        }
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {  //O(nlogn)
        if (head == null || head.next == null) {
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }

    public Node merge(Node left, Node right) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public void zigZagLL(Node head) {
        //find mid node
        Node mid = getMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;    //to break the linked list into 2
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //alternate merging
        Node rightH = prev;
        Node leftH = head;
        Node nextL, nextR;
        while (leftH != null && rightH != null) {
            //zigzag
            nextL = leftH.next;
            leftH.next = rightH;
            nextR = rightH.next;
            rightH.next = nextL;
            //update
            rightH = nextR;
            leftH = nextL;
        }
    }

    public Node intersectionPoint(Node head1, Node head2) {     //Brute force : O(n*m)
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            while (temp2 != null) {
                if (temp2.next == temp1.next) {
                    return temp2.next;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return null;
    }

    public Node getIntersectionNode(Node head1, Node head2) {   //O(m+n)
        if (head1 == null || head2 == null) {
            return null;
        }

        // Calculate the lengths of both lists
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        // Align the starting point for both lists
        while (length1 > length2) {
            head1 = head1.next;
            length1--;
        }

        while (length2 > length1) {
            head2 = head2.next;
            length2--;
        }

        // Move both pointers until they meet at the intersection point
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null; // No intersection
    }

    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    public void deleteNafterM(int m, int n, Node head) {
        Node temp = head;
        while (temp != null) {
            for (int i = 1; i < m && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                return;
            }
            Node temp1 = temp.next;
            for (int i = 1; i <= n && temp1 != null; i++) {
                temp1 = temp1.next;
            }
            temp.next = temp1;
            temp = temp1;
        }
    }

    public void swappingNodes(int x, int y, Node head) {
        if (x == y) {
            return;
        }
    
        Node prevX = null, currX = head;
        Node prevY = null, currY = head;
    
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
    
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
    
        if (currX == null || currY == null) {
            return;
        }
    
        // If x is not the head of the list
        if (prevX != null) {
            prevX.next = currY;
        } else { // If x is the head
            head = currY;
        }
    
        // If y is not the head of the list
        if (prevY != null) {
            prevY.next = currX;
        } else { // If y is the head
            head = currX;
        }
    
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    
    public Node oddEvenLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node temp1 = new Node(-1);
        Node temp2 = new Node(-1);
        Node oddHead = temp2;
        Node evenHead = temp1;

        while (temp != null) {
            if ((temp.data % 2) == 0) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (oddHead.next != null) {
            temp1.next = oddHead.next;
        }
        temp2.next = null;
        return evenHead.next;
    }

    public static void main(String[] args) {
        LinkedListAllImpFunctionsInJava ll = new LinkedListAllImpFunctionsInJava();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addMiddle(2, 3);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // // ll.addLast(1);
        // ll.printList();
        // System.out.println(ll.size);
        // System.out.println(ll.searchIterative(10));
        // System.out.println(ll.searchRecursive(4, 0, head));
        // ll.reverseLinkedList();
        // ll.printList();
        // ll.removeNthnodefromLast(3);
        // ll.printList();
        //System.out.println(ll.checkPalindrome());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = temp;
        // //1->2->3->4->2
        // System.out.println(isCycleFound());
        // removeCycle();
        // System.out.println(isCycleFound());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        //ll.addFirst(5);
        ll.printList();
        //ll.head = ll.mergeSort(ll.head);
        // ll.zigZagLL(ll.head);
        // ll.swappingNodes(2, 5, ll.head);
        ll.head = ll.oddEvenLL(ll.head);
        ll.printList();
    }
}
