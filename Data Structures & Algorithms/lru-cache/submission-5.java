class LRUCache {
    Map<Integer, ListNode> keyMap;
    DoublyLinkedList ll;
    int capacity;


    private class ListNode {
        int key;
        int val;
        int freq;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

    }

    private class DoublyLinkedList {
        ListNode start;
        ListNode end;
        int size;

        DoublyLinkedList() {
            this.start = new ListNode(0, 0);
            this.end = new ListNode(0,0);
            this.end.prev = this.start;
            this.start.next = end;
            this.size = 0;
        }

        public int length() {
            return size;
        }

        public void remove(ListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public void addFront(ListNode node) {
            node.next = this.start.next;
            node.prev = this.start;
            this.start.next.prev = node;
            start.next = node;
            size++;
        }
    }

    public LRUCache(int capacity) {
        this.keyMap = new HashMap<>();
        this.ll = new DoublyLinkedList();
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        ListNode node = keyMap.get(key);
        ll.remove(node);
        ll.addFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            ListNode node = keyMap.get(key);
            node.val = value;
            ll.remove(node);
            ll.addFront(node);
            return;
        }

        if (keyMap.size() == capacity) {
            ListNode node = ll.end.prev;
            ll.remove(node);
            keyMap.remove(node.key);
        }

        ListNode node = new ListNode(key, value);
        keyMap.put(key, node);
        ll.addFront(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */