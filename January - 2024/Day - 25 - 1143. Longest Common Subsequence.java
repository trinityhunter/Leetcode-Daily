class Solution {

    // public static int helper(String x, int m, String y, int n){

    //     if(m == 0 || n == 0){
    //         return 0;
    //     }

    //     if(dp[m][n]!=null){
    //         return dp[m][n];
    //     }

    //     if(x.charAt(m-1) == y.charAt(n-1)){
    //         return dp[m][n] = 1 + helper(x, m-1, y, n-1);
    //     }

    //     return dp[m][n] = Math.max(helper(x, m-1, y, n), helper(x, m, y, n-1));

    // }

    // public static Integer[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {

        // ***** Memoization ***** - 

        // dp = new Integer[text1.length()+1][text2.length()+1];

        // int ans = helper(text1, text1.length(), text2, text2.length());

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[text1.length()+1][text2.length()+1];

        // for(int i=0; i<text1.length()+1; i++){
        //     for(int j=0; j<text2.length()+1; j++){
        //         if(i == 0){
        //             dp[i][j] = 0;
        //         }
        //         else if(j == 0){
        //             dp[i][j] = 0;
        //         }
        //         else{
        //             if(text1.charAt(i-1) == text2.charAt(j-1)){
        //                 dp[i][j] = 1 + dp[i-1][j-1];
        //             }
        //             else{
        //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //             }
        //         }
        //     }
        // }

        // return dp[text1.length()][text2.length()];

        // ***** Space Optimized ***** - 

        int[] prev = new int[text2.length()+1];

        for(int i=0; i<text1.length()+1; i++){
            int[] curr = new int[text2.length()+1];
            for(int j=0; j<text2.length()+1; j++){
                if(i == 0){
                    curr[j] = 0;
                }
                else if(j == 0){
                    curr[j] = 0;
                }
                else{
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        curr[j] = 1 + prev[j-1];
                    }
                    else{
                        curr[j] = Math.max(prev[j], curr[j-1]);
                    }
                }
            }
            prev = curr;
        }

        return prev[text2.length()];

    }

}
