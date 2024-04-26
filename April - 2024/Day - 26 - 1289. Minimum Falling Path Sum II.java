class Solution {

    // public static int helper(int[][] grid, int sr, int sc){

    //     if(sr>grid.length-1){
    //         return Integer.MAX_VALUE;
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     int min = Integer.MAX_VALUE;

    //     for(int j=0; j<grid[0].length; j++){
    //         if(sc!=j){
    //             min = Math.min(min, helper(grid, sr+1, j));
    //         }
    //     }

    //     if(min == Integer.MAX_VALUE){
    //         return dp[sr][sc] = grid[sr][sc];
    //     }

    //     return dp[sr][sc] = min + grid[sr][sc];

    // }

    // public static Integer[][] dp;

    public int minFallingPathSum(int[][] grid) {

        // ***** Memoization ***** - 

        // dp = new Integer[grid.length][grid[0].length];

        // int ans = Integer.MAX_VALUE;

        // for(int j=0; j<grid[0].length; j++){
        //     ans = Math.min(ans, helper(grid, 0, j));
        // }

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[grid.length][grid[0].length];

        // for(int i=grid.length-1; i>=0; i--){
        //     for(int j=grid[0].length-1; j>=0; j--){
        //         if(i == grid.length-1){
        //             dp[i][j] = grid[i][j];
        //         }
        //         else{
        //             int min = Integer.MAX_VALUE;
        //             for(int k=0; k<grid[0].length; k++){
        //                 if(k!=j){
        //                     min = Math.min(min, dp[i+1][k]);
        //                 }
        //             }
        //             dp[i][j] = grid[i][j] + min;
        //         }
        //     }
        // }

        // int ans = Integer.MAX_VALUE;

        // for(int j=0; j<grid[0].length; j++){
        //     ans = Math.min(ans, dp[0][j]);
        // }

        // return ans;

        // ***** Space Optimized ***** - 

        int[] next = new int[grid[0].length];

        for(int i=grid.length-1; i>=0; i--){
            int[] curr = new int[grid[0].length];
            for(int j=grid[0].length-1; j>=0; j--){
                if(i == grid.length-1){
                    curr[j] = grid[i][j];
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k=0; k<grid[0].length; k++){
                        if(k!=j){
                            min = Math.min(min, next[k]);
                        }
                    }
                    curr[j] = grid[i][j] + min;
                }
            }
            next = curr;
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0; j<grid[0].length; j++){
            ans = Math.min(ans, next[j]);
        }

        return ans;

    }

}
