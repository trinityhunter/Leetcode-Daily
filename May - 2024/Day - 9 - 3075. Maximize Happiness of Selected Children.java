class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((p1,p2)->(p2-p1));

        int n = happiness.length;

        for(int i=0; i<n; i++){
            maxHeap.add(happiness[i]);
        }

        long ans = 0;

        int tmp = 0;

        int i = 0;

        while(!maxHeap.isEmpty() && k > 0){
            tmp = maxHeap.poll() - i;
            if(tmp <=0 ) break;
            ans += tmp;
            k--;
            i++;
        }

        return ans;

    }
    
}
