class Solution {

    public static int helper(int[] cost, int ind){

        if(ind == cost.length-1 || ind == cost.length-2){
            return cost[ind];
        }

        if(dp[ind]!=null){
            return dp[ind];
        }

        return dp[ind] = cost[ind] + Math.min(helper(cost, ind+1), helper(cost, ind+2));

    }

    public static Integer[] dp;

    public int minCostClimbingStairs(int[] cost) {

        dp = new Integer[cost.length];
        
        int ans = Math.min(helper(cost, 0), helper(cost, 1));

        return ans;

    }

}
