class Solution {

    public long largestPerimeter(int[] nums) {

        long sum = 0;

        List<Integer> arr = new ArrayList<>(nums.length);

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            arr.add(-nums[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(arr);

        long curr = sum;
        
        while(!pq.isEmpty() && curr <= -pq.peek() * 2){
            curr += pq.poll();
        }

        if(pq.size()>=2){
            return curr;
        }

        return -1;

    }
   
}
