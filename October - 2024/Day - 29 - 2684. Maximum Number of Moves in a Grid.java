class Solution {

    public static int helper(int[][] grid, int sr, int sc, int prev){

        if(sr<0 || sc<0 || sr>grid.length-1 || sc>grid[0].length-1 || grid[sr][sc]<=prev){
            return 0;
        }

        if(dp[sr][sc]!=null){
            return dp[sr][sc];
        }

        int ans = 0;

        ans = Math.max(ans, helper(grid, sr-1, sc+1, grid[sr][sc]));

        ans = Math.max(ans, helper(grid, sr, sc+1, grid[sr][sc]));

        ans = Math.max(ans, helper(grid, sr+1, sc+1, grid[sr][sc]));

        return dp[sr][sc] = ans+1;

    }

    public static Integer[][] dp;

    public int maxMoves(int[][] grid) {

        dp = new Integer[grid.length][grid[0].length];

        int ans = 1;

        for(int i=0; i<grid.length; i++){
            ans = Math.max(ans, helper(grid, i, 0, -1));
        }

        return ans-1;

    }

}
