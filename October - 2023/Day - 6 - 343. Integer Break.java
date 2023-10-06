class Solution {

    public int integerBreak(int n) {

        if(n == 2){
            return 1;
        }

        if(n == 3){
            return 2;
        }

        int[] dp = new int[n+1];

        dp[2] = 2;

        dp[3] = 3;

        for(int i=4; i<=n; i++){
            dp[i] = Math.max(dp[i-2] * 2, dp[i-3] * 3);
        }

        return dp[n];

    }

}
