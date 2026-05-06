class LRUCache {
    Map<Integer, CacheNode> cache;
    CacheNode front, end;
    int capacity;

    private class CacheNode {
        int key, val;
        CacheNode prev, next;
        CacheNode(int key, int val, CacheNode prev, CacheNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        front = new CacheNode(0, 0, null, null);
        end = new CacheNode(0, 0, front, null);
        front.next = end;
    }

    public void addFront(CacheNode node) {
        node.next = front.next;
        node.prev = front;
        front.next.prev = node;
        front.next = node;
    }

    public void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheNode node = cache.get(key);
        removeNode(node);
        addFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.val = value;
            get(key);
            return;
        }
        if (cache.size() == capacity) {
            CacheNode lru = end.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
        CacheNode node = new CacheNode(key, value, null, null);
        addFront(node);
        cache.put(key, node);
    }
}