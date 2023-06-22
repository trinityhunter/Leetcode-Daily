class Solution {

    // public static int helper(int[] prices, int fee, int ind, int buy){

    //     if(ind == prices.length-1){
    //         if(buy == 1){
    //             return Math.max(-prices[ind], 0);
    //         }
    //         else{
    //             return Math.max(prices[ind]-fee, 0);
    //         }
    //     }

    //     if(dp[ind][buy]!=null){
    //         return dp[ind][buy];
    //     }

    //     if(buy == 1){
    //         return dp[ind][buy] = Math.max(-prices[ind] + helper(prices, fee, ind+1, 0), helper(prices, fee, ind+1, 1));
    //     }
    //     else{
    //         return dp[ind][buy] = Math.max(prices[ind] - fee + helper(prices, fee, ind+1, 1), helper(prices, fee, ind+1, 0));
    //     }

    // }

    // public static Integer[][] dp;

    public int maxProfit(int[] prices, int fee) {

        // ***** Memoization ***** - 

        // dp = new Integer[prices.length][2];

        // int ans = helper(prices, fee, 0, 1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[prices.length][2];

        // for(int i=prices.length-1; i>=0; i--){
        //     for(int j=1; j>=0; j--){
        //         if(i == prices.length-1){
        //             if(j == 1){
        //                 dp[i][j] = Math.max(-prices[i], 0);
        //             }
        //             else{
        //                 dp[i][j] = Math.max(prices[i]-fee, 0);
        //             }
        //         }
        //         else{
        //             if(j == 1){
        //                 dp[i][j] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
        //             }
        //             else{
        //                 dp[i][j] = Math.max(prices[i] - fee + dp[i+1][1], dp[i+1][0]);
        //             }
        //         }
        //     }
        // }

        // return dp[0][1];

        // ***** Space Optimized ***** - 

        int[] next = new int[2];

        for(int i=prices.length-1; i>=0; i--){
            int[] curr = new int[2];
            for(int j=1; j>=0; j--){
                if(i == prices.length-1){
                    if(j == 1){
                        curr[j] = Math.max(-prices[i], 0);
                    }
                    else{
                        curr[j] = Math.max(prices[i]-fee, 0);
                    }
                }
                else{
                    if(j == 1){
                        curr[j] = Math.max(-prices[i] + next[0], next[1]);
                    }
                    else{
                        curr[j] = Math.max(prices[i] - fee + next[1], next[0]);
                    }
                }
            }
            next = curr;
        }

        return next[1];

    }

}
