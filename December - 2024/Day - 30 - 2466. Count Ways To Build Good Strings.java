class Solution {

    // public static int helper(int zero, int one, int ind){

    //     if(ind == 0){
    //         return 1;
    //     }

    //     if(ind < 0){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     int zeros = helper(zero, one, ind-zero) % 1000000007;

    //     int ones = helper(zero, one, ind-one) % 1000000007;

    //     return dp[ind] = (zeros+ones)%1000000007;

    // }

    // public static Integer[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {

        // Memoization - 

        // dp = new Integer[high+1];

        // int ans = 0;
        
        // for(int i=low; i<=high; i++){
        //     ans = (ans + helper(zero, one, i)) % 1000000007;
        // }

        // return ans;

        // Tabulation - 

        int ans = 0;

        int[] dp = new int[high+1];

        dp[0] = 1;

        for(int i=1; i<=high; i++){

            if(i >= zero){
                dp[i] = (dp[i] + dp[i - zero]) % 1000000007;
            }
            
            if(i >= one){
                dp[i] = (dp[i] + dp[i - one]) % 1000000007;
            }
            
            if(i >= low){
                ans = (ans + dp[i]) % 1000000007;
            }

        }

        return ans;

    }
    
}
