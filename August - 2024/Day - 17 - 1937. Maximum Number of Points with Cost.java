class Solution {

    // public static long helper(int[][] points, int sr, int sc){

    //     if(sr == points.length-1){
    //         return points[sr][sc];
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     long max = Long.MIN_VALUE;

    //     for(int j=0; j<points[0].length; j++){
    //         max = Math.max(max, helper(points, sr+1, j) - Math.abs(sc-j));
    //     }

    //     return dp[sr][sc] = max + points[sr][sc];

    // }

    // public static Long[][] dp;

    public long maxPoints(int[][] points) {

        // ***** Memoization ***** - 

        // dp = new Long[points.length][points[0].length];
        
        // long ans = Long.MIN_VALUE;

        // for(int j=0; j<points[0].length; j++){
        //     ans = Math.max(ans, helper(points, 0, j));
        // }

        // return ans;

        // ***** Tabulation ***** - 

        long[] dp = new long[points[0].length];
        
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points[0].length; j++){
                dp[j] += points[i][j];
            }
            
            for(int j=1; j<dp.length; j++){ 
                dp[j] = Math.max(dp[j], dp[j-1]-1);
            }
            
            for(int j=dp.length-2; j>=0; j--){
                dp[j] = Math.max(dp[j], dp[j+1]-1);
            }
        }
        
        long ans = 0;

        for(int i=0; i<dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;

    }

}
