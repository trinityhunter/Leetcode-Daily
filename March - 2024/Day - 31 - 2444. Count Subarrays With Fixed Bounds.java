class Solution {

    public long countSubarrays(int[] nums, int minK, int maxK) {

        long ans = 0;

        int mini = 0;

        int maxi = 0;

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == minK){
                mini = i;
            }

            if(nums[i] == maxK){
                maxi = i;
            }

            if(nums[i] < minK || nums[i] > maxK){
                count = i + 1;
                mini = maxi = i;
            }

            if(nums[mini] == minK && nums[maxi] == maxK){
                ans += Math.min(mini - count, maxi - count) + 1;
            }

        }

        return ans;

    }

}
