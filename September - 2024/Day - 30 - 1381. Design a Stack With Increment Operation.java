class CustomStack {

    int n;

    int[] arr;

    Stack<Integer> stack;

    public CustomStack(int maxSize) {
        n = maxSize;
        arr = new int[n];
        stack = new Stack<>();
    }

    public void push(int x) {

        if(stack.size() < n){
            stack.push(x);
        }

    }

    public int pop() {

        int i = stack.size() - 1;

        if(i<0){
            return -1;
        }

        if(i>0){
            arr[i - 1] += arr[i];
        }

        int res = stack.pop() + arr[i];

        arr[i] = 0;

        return res;

    }

    public void increment(int k, int val) {

        int i = Math.min(k, stack.size()) - 1;

        if(i >= 0){
            arr[i] += val;
        }

    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
