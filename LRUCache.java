public class LRUCache {
    // use the double-linked list
    Node head;
    Node tail;
    int capacity;
    private HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;
        Node cur = hm.get(key);
        
        // move the current node to the last
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        insertLast(cur);
        return hm.get(key).value;
    }
    
    public void set(int key, int value) {
        if (capacity < 1)
            return;
            
        // if the key exists, update the value
        // and move the node to the last
        if (get(key) != -1) {
            hm.get(key).value = value;
            return;
        }
          
        // check if the capacity is filled up  
        if (hm.size() == capacity) {
            hm.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        // add the new node
        Node aNode = new Node(key, value);
        insertLast(aNode);
        hm.put(key, aNode);
    }
    
    private void insertLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    
    private class Node {
        private Node prev;
        private Node next;
        int key;
        int value;
        
        Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
