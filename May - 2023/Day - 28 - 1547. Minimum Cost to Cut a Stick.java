class Solution {

    // public static int helper(int[] cuts, int i, int j){

    //     if(i>j){
    //         return 0;
    //     }

    //     if(dp[i][j]!=null){
    //         return dp[i][j];
    //     }

    //     int min = Integer.MAX_VALUE;

    //     for(int k=i; k<=j; k++){
    //         int steps = cuts[j+1] - cuts[i-1] + helper(cuts, i, k-1) + helper(cuts, k+1, j);

    //         min = Math.min(min, steps);
    //     }

    //     return dp[i][j] = min;

    // }

    // public static Integer[][] dp;

    public int minCost(int n, int[] cuts) {

        // Memoization - 

        // int[] nc = new int[cuts.length+2];

        // nc[0] = 0;

        // nc[nc.length-1] = n;

        // for(int i=0; i<cuts.length; i++){
        //     nc[i+1] = cuts[i];
        // }

        // Arrays.sort(nc);

        // dp = new Integer[nc.length][nc.length];
        
        // int ans = helper(nc, 1, cuts.length);

        // return ans;

        // Tabulation - 

        int[] nc = new int[cuts.length+2];

        nc[0] = 0;

        nc[nc.length-1] = n;

        for(int i=0; i<cuts.length; i++){
            nc[i+1] = cuts[i];
        }

        Arrays.sort(nc);

        int[][] dp = new int[cuts.length+2][cuts.length+2];

        for(int i=cuts.length; i>=1; i--){
            for(int j=1; j<=cuts.length; j++){

                if(i>j){
                    continue;
                }

                int min = Integer.MAX_VALUE;

                for(int k=i; k<=j; k++){
                    int steps = nc[j+1] - nc[i-1] + dp[i][k-1] + dp[k+1][j];

                    min = Math.min(min, steps);
                }

                dp[i][j] = min;
                
            }
        }

        return dp[1][cuts.length];

    }

}
