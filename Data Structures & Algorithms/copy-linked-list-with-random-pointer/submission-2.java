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
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node h1 = head;
        while (h1 != null) {
            if (!map.containsKey(h1)) {
                map.put(h1, new Node(h1.val));
            }
            map.get(h1).val = h1.val;
            if (!map.containsKey(h1.next)) {
                map.put(h1.next, new Node(0));
            }
            if (h1.next != null) {
                map.get(h1).next = map.get(h1.next);
            } 
            if (!map.containsKey(h1.random)) {
                map.put(h1.random, new Node(0));
            }
            if (h1.random != null) {
                map.get(h1).random = map.get(h1.random);
            }
            h1 = h1.next;
        }
        return map.get(head);
    }
}
