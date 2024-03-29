class Solution {

    public long countSubarrays(int[] nums, int k) {

        int max = Integer.MIN_VALUE;

        for(int i: nums){
            max = Math.max(max, i);
        }

        int l = 0; 
        
        int r = 0;

        long freq = 0;
        
        long count = 0;

        while(r < nums.length){

            while(r < nums.length && freq < k){
                if(nums[r++] == max){
                    freq++;
                }
            }

            while(freq >= k){
                count += nums.length - r + 1;
                if(nums[l++] == max){
                    freq--;
                }
            }
            
        }

        return count;

    }

}
