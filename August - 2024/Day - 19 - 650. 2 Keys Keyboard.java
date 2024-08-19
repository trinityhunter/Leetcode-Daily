class Solution {

    public static int helper(int n, int copied, int total, int steps){

        if(total>n){
            return Integer.MAX_VALUE;
        }

        if(total == n){
            return steps;
        }

        if(dp[total][steps]!=null){
            return dp[total][steps];
        }

        int paste = helper(n, copied, total+copied, steps+1);

        int copy = helper(n, total, total+total, steps+2);

        return dp[total][steps] = Math.min(copy, paste);

    }

    public static Integer[][] dp;

    public int minSteps(int n) {

        if(n == 1){
            return 0;
        }

        dp = new Integer[n+1][n+1];

        int ans = helper(n, 1, 1, 0);

        return ans+1;

    }

}
