class Solution {

    // public static int helper(int[][] grid, int sr, int sc1, int sc2){

    //     if(sr<0 || sc1<0 | sc2<0 || sr>grid.length-1 || sc1>grid[0].length-1 || sc2>grid[0].length-1){
    //         return 0;
    //     }

    //     if(dp[sr][sc1][sc2]!=null){
    //         return dp[sr][sc1][sc2];
    //     }

    //     int max = 0;

    //     for(int i=-1; i<=1; i++){
    //         for(int j=-1; j<=1; j++){
    //             max = Math.max(max, helper(grid, sr+1, sc1+i, sc2+j));
    //         }
    //     }

    //     if(sc1 == sc2){
    //         return dp[sr][sc1][sc2] = max + grid[sr][sc1];
    //     }

    //     return dp[sr][sc1][sc2] = max + grid[sr][sc1] + grid[sr][sc2];

    // }

    // public static Integer[][][] dp;

    public int cherryPickup(int[][] grid) {

        // ***** Memoization ***** - 

        // dp = new Integer[grid.length][grid[0].length][grid[0].length];

        // int ans = helper(grid, 0, 0, grid[0].length-1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        // for(int i=0; i<grid[0].length; i++){
        //     for(int j=0; j<grid[0].length; j++){
        //         if(i == j){
        //             dp[grid.length-1][i][j] = grid[grid.length-1][i];
        //         }
        //         else{
        //             dp[grid.length-1][i][j] = grid[grid.length-1][i] + grid[grid.length-1][j];
        //         }
        //     }
        // }

        // for(int i=grid.length-2; i>=0; i--){
        //     for(int j=0; j<grid[0].length; j++){
        //         for(int k=0; k<grid[0].length; k++){
        //             int max = 0;

        //             for(int l=-1; l<=1; l++){
        //                 for(int m=-1; m<=1; m++){
        //                     int value = 0;
        //                     if(j == k){
        //                         value = grid[i][j];
        //                     }
        //                     else{
        //                         value = grid[i][j] + grid[i][k];
        //                     }
        //                     if(i+1<0 || j+l<0 | k+m<0 || i+1>grid.length-1 || j+l>grid[0].length-1 || k+m>grid[0].length-1){
        //                         value += Integer.MIN_VALUE;
        //                     }
        //                     else{
        //                         value += dp[i+1][j+l][k+m];
        //                     }
        //                     max = Math.max(max, value);
        //                 }
        //             }
        //             dp[i][j][k] = max;
        //         }
        //     }
        // }

        // return dp[0][0][dp[0].length-1];

        // ***** Space Optimized ***** - 

        int[][] next = new int[grid[0].length][grid[0].length];

        for(int i=0; i<grid[0].length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i == j){
                    next[i][j] = grid[grid.length-1][i];
                }
                else{
                    next[i][j] = grid[grid.length-1][i] + grid[grid.length-1][j];
                }
            }
        }

        for(int i=grid.length-2; i>=0; i--){
            int[][] curr = new int[grid[0].length][grid[0].length];
            for(int j=0; j<grid[0].length; j++){
                for(int k=0; k<grid[0].length; k++){
                    int max = 0;

                    for(int l=-1; l<=1; l++){
                        for(int m=-1; m<=1; m++){
                            int value = 0;
                            if(j == k){
                                value = grid[i][j];
                            }
                            else{
                                value = grid[i][j] + grid[i][k];
                            }
                            if(i+1<0 || j+l<0 | k+m<0 || i+1>grid.length-1 || j+l>grid[0].length-1 || k+m>grid[0].length-1){
                                value += Integer.MIN_VALUE;
                            }
                            else{
                                value += next[j+l][k+m];
                            }
                            max = Math.max(max, value);
                        }
                    }
                    curr[j][k] = max;
                }
            }
            next = curr;
        }

        return next[0][grid[0].length-1];

    }

}
