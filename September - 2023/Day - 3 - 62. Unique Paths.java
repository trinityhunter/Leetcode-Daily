class Solution {

    public static int helper(int sr, int sc){

        if(sr<0 || sc<0){
            return 0;
        }

        if(dp[sr][sc]!=null){
            return dp[sr][sc];
        }

        if(sr == 0 && sc == 0){
            return 1;
        }

        return dp[sr][sc] = helper(sr-1, sc) + helper(sr, sc-1);

    }

    public static Integer[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new Integer[m][n];

        int ans = helper(m-1, n-1);

        return ans;

    }

}
