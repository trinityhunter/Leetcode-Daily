class MyCircularDeque {

    int capacity;
    
    int head;
    
    int tail;
    
    int n;

    int[] A;

    public MyCircularDeque(int k) {

        this.capacity = k;

        this.n = k + 1;

        A = new int[n];

    }

    public boolean insertFront(int value) {

        if(isFull()){
            return false;
        }

        A[head] = value;

        head = (head - 1 + n) % (n);

        return true;

    }

    public boolean insertLast(int value) {

        if(isFull()){
            return false;
        }

        tail = (tail + 1) % n;

        A[tail] = value;

        return true;

    }

    public boolean deleteFront() {

        if(isEmpty()){
            return false;
        }

        head = (head + 1) % n;

        return true;

    }

    public boolean deleteLast() {

        if(isEmpty()){
            return false;
        }

        tail = (tail - 1 + n) % n;

        return true;

    }

    public int getFront() {

        return isEmpty() ? -1 : A[(head + 1) % n];

    }

    public int getRear() {

        return isEmpty() ? -1 : A[tail];

    }

    public boolean isEmpty() {

        return head == tail;

    }

    public boolean isFull() {

        return head == (tail + 1) % n;

    }
    
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
