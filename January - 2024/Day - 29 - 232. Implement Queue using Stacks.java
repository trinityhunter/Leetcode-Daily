class MyQueue {

    Stack<Integer> st1;

    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack();
        st2 = new Stack();
        
    }
    
    public void push(int x) {

        st1.push(x);
        
    }
    
    public int pop() {
         
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        int pop = st2.pop();

        while(!st2.isEmpty()){

            st1.push(st2.pop());

        }

        return pop;
        
    }
    
    public int peek() {
         
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        int peek = st2.peek();

        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }

        return peek;
        
    }
    
    public boolean empty() {

        return st1.isEmpty();
        
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
