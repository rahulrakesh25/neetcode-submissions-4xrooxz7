class LRUCache {
    Map<Integer, CacheNode> cache;
    CacheNode start;
    CacheNode last;
    int capacity;

    private class CacheNode {
        int key;
        int val;
        CacheNode next;
        CacheNode prev;

        CacheNode(int key, int val, CacheNode next, CacheNode prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        start = new CacheNode(0, 0, null, null);
        last = new CacheNode(0, 0, null, start);
        start.next = last;
    }

    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(CacheNode node) {
        node.next = start.next;
        node.prev = start;
        start.next.prev = node;
        start.next = node;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; 
        }
        CacheNode node = cache.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key) && cache.get(key) != null) {
            CacheNode node = cache.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }
        if (cache.size() == capacity) {
            CacheNode lru = last.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
        CacheNode node1 = new CacheNode(key, value, start.next, start);
        addNode(node1);
        cache.put(key, node1);
    }
}
