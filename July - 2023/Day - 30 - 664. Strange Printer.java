class Solution {

    public int strangePrinter(String s) {

        int[][] dp = new int[s.length()][s.length()];
        
        for(int i=s.length()-1; i>=0; i--){

            dp[i][i] = 1;

            for(int j=i+1; j<s.length(); j++){

                dp[i][j] = dp[i][j-1] + 1;

                for(int k=i; k<j; k++){
                    if(s.charAt(k) == s.charAt(j)){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + (k+1<=j-1 ? dp[k+1][j-1] : 0));
                    }
                }

            }

        }

        return dp[0][s.length()-1];

    }

}
