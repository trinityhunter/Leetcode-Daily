class Solution {

    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;

        if(n < d){
            return -1;
        }

        int[][] dp = new int[n + 1][d + 1];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE / 2));

        dp[0][0] = 0;

        for(int i=1; i<=n; i++){
            for (int k = 1; k <= d; ++k) {
                int maxDifficulty = 0;
                for (int j=i-1; j>=k-1; j--){                       
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]); 
                    dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + maxDifficulty);
                }
            }
        }

        return dp[n][d];

    }
    
}
