class Solution {

    public static int helper(int n, int m, int k, int max, int ind){

        if(ind == n){
            if(k == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(dp[ind][k][max] != null){
            return dp[ind][k][max];
        }

        if(k == 0 && ind < n){

            long temp = 1;

            for(int i=1; i<=n-ind; i++){
                temp = (temp * max) % 1000000007;
            }

            return (int)temp;

        }

        long ans = 0;

        for(int i=1; i<=m; i++){
            if(i>max){
                ans = (ans + helper(n, m, k-1, i, ind+1))%1000000007;
            }
            else{
                ans = (ans + helper(n, m, k, max, ind+1))%1000000007;
            }
        }

        return dp[ind][k][max] = (int)ans%1000000007;

    }

    public static Integer[][][] dp;

    public int numOfArrays(int n, int m, int k) {

        dp = new Integer[n][k+1][m+1];

        int ans = helper(n, m, k, 0, 0);

        return ans;

    }

}
