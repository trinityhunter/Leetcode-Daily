class Solution {

    public static int helper(int[] nums, int ind, int target){

        if(target == 0){
            return 1;
        }

        if(ind == nums.length){
            return 0;
        }

        if(dp[target]!=null){
            return dp[target];
        }

        int notPick = helper(nums, ind+1, target);

        int pick = 0;

        if(nums[ind]<=target){
            pick = helper(nums, 0, target-nums[ind]);
        }

        return dp[target] = pick + notPick;

    }

    public static Integer[] dp;

    public int combinationSum4(int[] nums, int target) {

        dp = new Integer[target+1];
        
        int ans = helper(nums, 0, target);

        return ans;

    }

}
