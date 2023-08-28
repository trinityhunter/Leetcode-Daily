class MyStack {

    Queue<Integer> q;

	int top;

    public MyStack() {

    	q = new ArrayDeque<>();

    }
    
    public void push(int x) {

        q.add(x);

        top = x;

    }
    
    public int pop() {

        int size = q.size();

        while(size>1){

            top = q.remove();

            q.add(top);
            
            size--;

        }

        return q.remove();

    }
    
    public int top() {

        return top;

    }
    
    public boolean empty() {

        return (q.size() == 0)?true:false;

    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
