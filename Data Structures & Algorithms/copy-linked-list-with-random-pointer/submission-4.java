/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node h1 = head;

        while (h1 != null) {
            Node h2 = new Node(h1.val);
            h2.next = h1.next;
            h1.next = h2;
            h1 = h2.next;
        }

        h1 = head;
        while (h1 != null) {
            Node h2 = h1.next;
            if (h1.random != null) {
                h2.random = h1.random.next;
            }
            h1 = h2.next;
        }

        Node newHead = head.next;
        h1 = head;
        while (h1 != null) {
            Node h2 = h1.next;
            h1.next = h2.next;
            if (h2.next != null) {
                h2.next = h2.next.next;
            }
            h1 = h1.next;
        }

        return newHead;
        
    }
}