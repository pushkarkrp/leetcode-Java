class LRUCache {
    
    class Node {
        Node next, prev;
        int key, value;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node head, tail;
    private int capacity, current = 0;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void add(Node node) {
        Node temp = head.next;
        head.next = node;
        temp.prev = node;
        node.next = temp;
        node.prev = head;
    }
    
    public void update(Node node) {
        remove(node);
        add(node);
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            add(node);
            ++current;
        }
        if (current > capacity) {
            Node prevNode = tail.prev;
            remove(prevNode);
            map.remove(prevNode.key);
            current--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */