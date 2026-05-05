class MyCircularQueue {
    int capacity;
    int size;
    ListNode start;
    ListNode end;

    private class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyCircularQueue(int k) {
        this.capacity = k;
        start = new ListNode(0, null, null);
        end = new ListNode(0, start, null);
        start.next = end;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value, end.prev, end);
        end.prev.next = node;
        end.prev = node;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        ListNode node = start.next;
        start.next = node.next;
        node.next.prev = start;
        node = null;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : start.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : end.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return capacity == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */