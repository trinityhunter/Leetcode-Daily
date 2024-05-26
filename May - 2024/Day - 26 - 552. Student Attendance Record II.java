class Solution {

    int mod=(int)1e9 + 7;

    private int solve(int n,int abs,int late,int[][][] dp){

        if(abs==2 || late==3){
            return 0;
        }

        if(n == 0){

            if(abs==1 && late==2){
                return 1;
            }

            if(abs==1 || late==2){
                return 2;
            }

            return 3;
        }

        if(dp[n][abs][late]!=-1){
            return dp[n][abs][late];
        }

        int p = solve(n-1,abs,0,dp);

        int a = solve(n-1,abs+1,0,dp);
        
        int l = solve(n-1,abs,late+1,dp);

        return dp[n][abs][late] = ((p%mod + a%mod)%mod + l%mod)%mod;

    }

    public int checkRecord(int n) {
        
        int[][][] dp = new int[n][2][3];

        for(int[][] rows:dp){
            for(int[] row:rows){
                Arrays.fill(row,-1);
            }
        }

        return solve(n-1,0,0,dp);

    }
    
}
