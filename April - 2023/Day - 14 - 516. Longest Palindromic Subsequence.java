class Solution {
  
    // Memoization - 

    // public static int helper(String x, String y, int ind1, int ind2){

    //     if(ind1<0 || ind2<0){
    //         return 0;
    //     }

    //     if(dp[ind1][ind2]!=null){
    //         return dp[ind1][ind2];
    //     }

    //     if(x.charAt(ind1) == y.charAt(ind2)){
    //         return dp[ind1][ind2] = 1 + helper(x, y, ind1-1, ind2-1);
    //     }

    //     return dp[ind1][ind2] = Math.max(helper(x, y, ind1-1, ind2), helper(x, y, ind1, ind2-1));

    // }

    // public static Integer[][] dp;

    public int longestPalindromeSubseq(String s) {
        
        // StringBuilder sb = new StringBuilder();

        // for(int i=s.length()-1; i>=0; i--){
        //     sb.append(s.charAt(i));
        // }

        // dp = new Integer[s.length()][sb.toString().length()];

        // int ans = helper(s, sb.toString(), s.length()-1, sb.toString().length()-1);

        // return ans;
      
        // Tabulation - 

        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }

        int[][] dp = new int[s.length()+1][sb.toString().length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = 0;
                }
                else if(j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(s.charAt(i-1) == sb.toString().charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];

    }
}
