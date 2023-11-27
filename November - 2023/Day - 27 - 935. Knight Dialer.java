class Solution {

    public static int MOD = 1_000_000_007;

    public static int helper(int n, int curr, int[][]graph){

        if(n == 0){
            return 1;
        }

        if(dp[n][curr]!=null){
            return dp[n][curr];
        }
        
        int count = 0;

        for(var i: graph[curr]){
            count = (count + helper(n-1, i, graph))%MOD;
        }

        return dp[n][curr] = count;

    }

    public static Integer[][] dp;

    public int knightDialer(int n) {

        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};

        int count = 0;

        dp = new Integer[n+1][10];

        for(int i=0; i<10; i++){
            count = (count + helper(n-1, i, graph))%MOD;
        }

        return count;

    }

}
