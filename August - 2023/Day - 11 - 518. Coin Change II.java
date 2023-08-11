class Solution {

    // public static int helper(int[] coins, int ind, int amount){

    //     if(ind == 0){
    //         if(amount%coins[ind] == 0){
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     if(dp[ind][amount]!=null){
    //         return dp[ind][amount];
    //     }

    //     int notPick = helper(coins, ind-1, amount);

    //     int pick = 0;

    //     if(amount-coins[ind]>=0){
    //         pick = helper(coins, ind, amount-coins[ind]);
    //     }

    //     return dp[ind][amount] = pick + notPick;

    // }

    // public static Integer[][] dp;

    public int change(int amount, int[] coins) {

        // ***** Memoization ***** - 

        // dp = new Integer[coins.length][amount+1];

        // int ans = helper(coins, coins.length-1, amount);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[coins.length][amount+1];

        // for(int i=0; i<coins.length; i++){
        //     for(int j=0; j<amount+1; j++){
        //         if(i == 0){
        //             if(j%coins[i] == 0){
        //                 dp[i][j] = 1;
        //             }
        //             else{
        //                 dp[i][j] = 0;
        //             }
        //         }
        //         else{
        //             int notPick = dp[i-1][j];

        //             int pick = 0;

        //             if(j-coins[i]>=0){
        //                 pick = dp[i][j-coins[i]];
        //             }

        //             dp[i][j] = pick + notPick;
        //         }
        //     }
        // }

        // return dp[coins.length-1][amount];

        // ***** Space Optimized ***** - 

        int[] prev = new int[amount+1];

        for(int i=0; i<coins.length; i++){
            int[] curr = new int[amount+1];
            for(int j=0; j<amount+1; j++){
                if(i == 0){
                    if(j%coins[i] == 0){
                        curr[j] = 1;
                    }
                    else{
                        curr[j] = 0;
                    }
                }
                else{
                    int notPick = prev[j];

                    int pick = 0;

                    if(j-coins[i]>=0){
                        pick = curr[j-coins[i]];
                    }

                    curr[j] = pick + notPick;
                }
            }
            prev = curr;
        }

        return prev[amount];

    }

}
