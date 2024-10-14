class Solution {

    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        
        long count = 0;
        
        while(pq.size()>0 && k>0){
            int rem = pq.remove();
            count += rem;
            int ad = (int)Math.ceil((double)rem/3);
            pq.add(ad);
            
            k--;
        }
        
        return count;
        
    }
    
}
