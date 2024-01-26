class Solution {

    public static int helper(int m, int n, int sr, int sc, int moves){

        if(sr >= m || sc >= n || sr < 0|| sc < 0){
            return 1;
        }
        
        if(moves == 0){
            return 0;
        }

        if(dp[sr][sc][moves]!=null){
            return dp[sr][sc][moves];
        }

        int left = helper(m, n, sr, sc-1, moves-1);

        int right = helper(m, n, sr, sc+1, moves-1);

        int bottom = helper(m, n, sr+1, sc, moves-1);

        int top = helper(m, n, sr-1, sc, moves-1);

        return dp[sr][sc][moves] = (((((left+right)%1000000007)+bottom)%1000000007)+top)%1000000007;

    }

    public static Integer[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dp = new Integer[m+1][n+1][maxMove+1];

        int ans = helper(m, n, startRow, startColumn, maxMove);

        return ans;

    }

}
