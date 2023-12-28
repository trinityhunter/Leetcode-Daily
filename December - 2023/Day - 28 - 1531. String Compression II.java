class Solution {

    public int getLengthOfOptimalCompression(String s, int k){

        int n = s.length();

        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=k; j++){
                dp[i][j] = n;
            }
        }

        dp[0][0] = 0;

        for(int i=1; i<=n; i++){
            char c = s.charAt(i-1);
            for(int j=0; j<=k; j++){
                int count = 0;
                int delete = 0;
                for(int l=i; l>0; l--){

                    if(s.charAt(l-1)==c){
                        count++;
                    }
                    else{
                        delete++;
                    }

                    if(j<delete){
                        break;
                    }

                    int result = (count == 1) ? 1 : (count < 10) ? 2 : (count < 100) ? 3 : 4;

                    dp[i][j] = Math.min(dp[i][j], dp[l-1][j-delete] + result);
                }
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
            }
        }

        return dp[n][k];

    }
    
}
