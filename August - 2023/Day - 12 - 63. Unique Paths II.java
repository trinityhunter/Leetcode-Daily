class Solution {

    // public static int helper(int[][] grid, int sr, int sc){

    //     if(sr == 0 && sc == 0){
    //         return 1;
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     int ans = 0;

    //     if(sr-1>=0 && grid[sr-1][sc]!=1){
    //         ans += helper(grid, sr-1, sc);
    //     }

    //     if(sc-1>=0 && grid[sr][sc-1]!=1){
    //         ans += helper(grid, sr, sc-1);
    //     }

    //     return dp[sr][sc] = ans;

    // }

    // public static Integer[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // ***** Memoization ***** - 

        // if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
        //     return 0;
        // }

        // dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        
        // int ans = helper(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);

        // return ans;

        // ***** Tabulation ***** - 

        // if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
        //     return 0;
        // }

        // int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        // for(int i=0; i<obstacleGrid.length; i++){
        //     for(int j=0; j<obstacleGrid[0].length; j++){
        //         if(i == 0 && j == 0){
        //             dp[i][j] = 1;
        //         }
        //         else{
        //             int ans = 0;

        //             if(i-1>=0 && obstacleGrid[i-1][j]!=1){
        //                 ans += dp[i-1][j];
        //             }

        //             if(j-1>=0 && obstacleGrid[i][j-1]!=1){
        //                 ans += dp[i][j-1];
        //             }

        //             dp[i][j] = ans;
        //         }
        //     }
        // }

        // return dp[dp.length-1][dp[0].length-1];

        // ***** Space Optimized ***** - 

        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }

        int[] prev = new int[obstacleGrid[0].length];

        for(int i=0; i<obstacleGrid.length; i++){
            int[] curr = new int[obstacleGrid[0].length];
            for(int j=0; j<obstacleGrid[0].length; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else{
                    int ans = 0;

                    if(i-1>=0 && obstacleGrid[i-1][j]!=1){
                        ans += prev[j];
                    }

                    if(j-1>=0 && obstacleGrid[i][j-1]!=1){
                        ans += curr[j-1];
                    }

                    curr[j] = ans;
                }
            }
            prev = curr;
        }

        return prev[obstacleGrid[0].length-1];

    }

}
