class Solution {

    public static int helper(int[] rods, int ind, int target){

        if(ind == rods.length){

            if(target == 0){
                return 0;
            }

            return Integer.MIN_VALUE;

        }

        if(dp[ind][target+5000]!=null){
            return dp[ind][target+5000];
        }

        int notPick = helper(rods, ind+1, target);

        int pick1 = rods[ind] + helper(rods, ind+1, target+rods[ind]);

        int pick2 = helper(rods, ind+1, target-rods[ind]);

        return dp[ind][target+5000] = Math.max(notPick, Math.max(pick1, pick2));

    }

    public static Integer[][] dp;

    public int tallestBillboard(int[] rods) {

        // ***** Memoization ***** - 

        dp = new Integer[rods.length+1][10004];
        
        int ans = helper(rods, 0, 0);

        return ans;

    }

}
