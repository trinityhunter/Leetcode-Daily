class Solution {

    // public static int helper(int[][] matrix, int sr, int sc){

    //     if(sr == matrix.length-1){
    //         return matrix[sr][sc];
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     int min = Integer.MAX_VALUE;

    //     if(sr+1<matrix.length && sc-1>=0){
    //         min = Math.min(min, helper(matrix, sr+1, sc-1));
    //     }

    //     if(sr+1<matrix.length){
    //         min = Math.min(min, helper(matrix, sr+1, sc));
    //     }

    //     if(sr+1<matrix.length && sc+1<matrix[sr].length){
    //         min = Math.min(min, helper(matrix, sr+1, sc+1));
    //     }

    //     return dp[sr][sc] = min + matrix[sr][sc];

    // }

    // public static Integer[][] dp;

    public int minFallingPathSum(int[][] matrix) {

        // ***** Memoization ***** - 

        // dp = new Integer[matrix.length][matrix[0].length];

        // int ans = Integer.MAX_VALUE;

        // for(int j=0; j<matrix[0].length; j++){
        //     ans = Math.min(ans, helper(matrix, 0, j));
        // }

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[matrix.length][matrix[0].length];

        // for(int i=matrix.length-1; i>=0; i--){
        //     for(int j=matrix[i].length-1; j>=0; j--){
        //         if(i == matrix.length-1){
        //             dp[i][j] = matrix[i][j];
        //         }
        //         else{
        //             int min = Integer.MAX_VALUE;

        //             if(i+1<matrix.length && j-1>=0){
        //                 min = Math.min(min, dp[i+1][j-1]);
        //             }

        //             if(i+1<matrix.length){
        //                 min = Math.min(min, dp[i+1][j]);
        //             }

        //             if(i+1<matrix.length && j+1<matrix[i].length){
        //                 min = Math.min(min, dp[i+1][j+1]);
        //             }

        //             dp[i][j] = min + matrix[i][j];
        //         }
        //     }
        // }

        // int ans = Integer.MAX_VALUE;

        // for(int j=0; j<matrix[0].length; j++){
        //     ans = Math.min(ans, dp[0][j]);
        // }

        // return ans;

        // ***** Space Optimized ***** - 

        int[] next = new int[matrix[0].length];

        for(int i=matrix.length-1; i>=0; i--){
            int[] curr = new int[matrix[0].length];
            for(int j=matrix[i].length-1; j>=0; j--){
                if(i == matrix.length-1){
                    curr[j] = matrix[i][j];
                }
                else{
                    int min = Integer.MAX_VALUE;

                    if(i+1<matrix.length && j-1>=0){
                        min = Math.min(min, next[j-1]);
                    }

                    if(i+1<matrix.length){
                        min = Math.min(min, next[j]);
                    }

                    if(i+1<matrix.length && j+1<matrix[i].length){
                        min = Math.min(min, next[j+1]);
                    }

                    curr[j] = min + matrix[i][j];
                }
            }
            next = curr;
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0; j<matrix[0].length; j++){
            ans = Math.min(ans, next[j]);
        }

        return ans;

    }

}
