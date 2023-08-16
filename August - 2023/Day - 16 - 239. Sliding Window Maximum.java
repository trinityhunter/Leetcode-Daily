class Solution {

    public int[] maxSlidingWindow(int[] arr, int k) {

        int ans[]=new int[arr.length-k+1];

        Deque<Integer> dq = new LinkedList<>();

        int i=0;
                
        int j=0;

        while(j<arr.length) {
                        
            if(dq.size()==0) {
                dq.add(arr[j]);
            }
            else{

                while(dq.size()>0 && dq.peekLast()<arr[j]) {
                    dq.removeLast();
                }

                dq.add(arr[j]);

            }
            
            if(j-i+1<k) {
                j++;
            }
            else if(j-i+1==k) {
                                
                ans[i]=dq.peek();
                                
                if(arr[i]==dq.peek()) {
                    dq.removeFirst();
                }
                i++;
                j++;
            }

        }
        
        return ans;  

    }

}
