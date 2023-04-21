class Solution {

    public static int helper(int n, int minProfit, int []group, int []profit, int ind){

        if(n == 0){
            if(minProfit == 0){
                return 1;
            }
            return 0;
        }
        
        if(ind == group.length){
            if(minProfit == 0){
                return 1;
            }
            return 0;
        }
        
        if(dp[n][minProfit][ind]!=null){
            return dp[n][minProfit][ind];
        }
        
        int pick = 0;
        
        if(n >= group[ind]){
            pick += helper(n-group[ind], Math.max(0, minProfit-profit[ind]), group, profit, ind+1) % mod;
        }
        
        int notPick = helper(n, minProfit, group, profit, ind+1) % mod;
        
        return dp[n][minProfit][ind] = (pick + notPick) % mod;

    }

    public static int mod;

    public static Integer[][][] dp;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        mod = (int)1e9+7;

        dp = new Integer[n+1][minProfit+1][group.length];
        
        return helper(n, minProfit, group, profit, 0);

    }

}
