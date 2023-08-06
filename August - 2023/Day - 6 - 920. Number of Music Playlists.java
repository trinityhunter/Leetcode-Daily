class Solution {

    public static long helper(int n, int goal, int k, int ind, int num){

        if(ind == goal){
            if(num == n){
                return 1;
            }
            return 0;
        }

        if(dp[ind][num] != null){
            return dp[ind][num];
        }

        long way1 = (long)Math.max(0, num - k) * helper(n, goal, k, ind+1, num);

        way1 %= mod;

        long way2 = 0;

        if(num<n){
            way2 =  helper(n, goal, k, ind+1, num+1) * (long)(n-num);
        }

        way2 %=mod;

        return dp[ind][num]= ((way1 + way2) % mod);

    }

    public static int mod = 1000000007;

    public static Long[][] dp;

    public int numMusicPlaylists(int n, int goal, int k) {

        dp = new Long[goal+1][n+1];

        int ans = (int)helper(n, goal, k, 0, 0);

        return ans;

    }

}
