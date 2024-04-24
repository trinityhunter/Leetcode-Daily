class Solution {

    public static int helper(int n){

        if(n == 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        if(dp[n]!=null){
            return dp[n];
        }

        return dp[n] = helper(n-1) + helper(n-2) + helper(n-3);

    }

    public static Integer[] dp;

    public int tribonacci(int n) {

        dp = new Integer[n+1];

        int ans = helper(n);

        return ans;

    }

}
