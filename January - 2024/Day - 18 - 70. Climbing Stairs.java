class Solution {

    // public static int helper(int n){

    //     if(n<0){
    //         return 0;
    //     }

    //     if(n == 0){
    //         return 1;
    //     }

    //     if(dp[n]!=null){
    //         return dp[n];
    //     }

    //     return dp[n] = helper(n-1) + helper(n-2);

    // }

    // public static Integer[] dp;

    public int climbStairs(int n) {

        // ***** Memoization ***** - 

        // dp = new Integer[n+1];
        
        // int ans = helper(n);

        // return ans;

        // ***** Tabulation ***** - 

        // int[] dp = new int[n+1];

        // for(int i=0; i<n+1; i++){
        //     if(i == 0){
        //         dp[i] = 1;
        //     }
        //     else if(i == 1 || i == 2){
        //         dp[i] = i;
        //     }
        //     else{
        //         dp[i] = dp[i-1] + dp[i-2];
        //     }
        // }

        // return dp[n];

        // ***** Space Optimized ***** - 

        int ans = 0;

        int prev = 2;

        int prevprev = 1;

        for(int i=0; i<n+1; i++){
            if(i == 0){
                ans = 1;
            }
            else if(i == 1 || i == 2){
                ans = i;
            }
            else{
                ans = prev + prevprev;
                prevprev = prev;
                prev = ans;
            }
        }

        return ans;

    }

}
