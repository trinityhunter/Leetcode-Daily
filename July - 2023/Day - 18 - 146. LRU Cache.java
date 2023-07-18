class LRUCache {

    class Node {

        Node prev;
        
        Node next;

        int val;

        int key;

        Node(int key, int val){

            this.key = key;

            this.val = val;

            prev = null;

            next = null;

        }

    }

    void insert(Node node){

        node.next = head.next;

        head.next.prev = node;

        head.next = node;

        node.prev = head;

    }

    void remove(Node node){

        node.prev.next = node.next;

        node.next.prev = node.prev;

    }

    HashMap<Integer, Node> mp = new HashMap<>();

    int capacity;

    Node head;
    
    Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        head = new Node(-1, -1);

        tail = new Node(-1, -1);

        head.next = tail;

        tail.prev = head;

    }
    
    public int get(int key) {

        if(!mp.containsKey(key)){
            return -1;
        }

        Node res = mp.get(key);

        remove(res);

        insert(res);

        return res.val;

    }
    
    public void put(int key, int value) {

        Node newNode;

        if(mp.containsKey(key)){

            newNode = mp.get(key);

            remove(newNode);

            newNode.val = value;

        } 
        else{

            if(mp.size() == capacity){

                Node toRemove = tail.prev;

                mp.remove(toRemove.key);

                remove(toRemove);

            }

            newNode = new Node(key, value);

        }

        insert(newNode);

        mp.put(key, newNode);

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
