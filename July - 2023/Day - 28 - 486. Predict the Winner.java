class Solution {

    public static int helper(int[] nums, int i, int j){

        if(i>j){
            return 0;
        }

        if(i==j){
            return nums[i];
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        return dp[i][j] = Math.max(nums[i] + Math.min(helper(nums, i + 2, j), helper(nums, i + 1, j - 1)), nums[j] + Math.min(helper(nums, i, j - 2), helper(nums, i + 1, j - 1)));

    }

    public static Integer[][] dp;

    public boolean PredictTheWinner(int[] nums) {

        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        dp = new Integer[nums.length][nums.length];
        
        int ans = helper(nums, 0, nums.length-1);

        return ans>=sum-ans;

    }

}
