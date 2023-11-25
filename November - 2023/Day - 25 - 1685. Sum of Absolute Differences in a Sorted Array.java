class Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
           ans[i] = ((nums[i] * (i+1)) - prefix[i]) + ((prefix[nums.length-1] - prefix[i]) - nums[i]*(nums.length-1-i));
        }

        return ans;

    }

}
