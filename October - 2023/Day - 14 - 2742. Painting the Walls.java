class Solution {

    public static int paintWalls(int[] cost, int[] time, int i, int walls){

        if(walls <= 0){
            return 0;
        }

        if(i == cost.length){
            return kMax;
        }

        if(dp[i][walls] > 0){
            return dp[i][walls];
        }

        int notPick = paintWalls(cost, time, i+1, walls);
        
        int pick = cost[i] + paintWalls(cost, time, i+1, walls-time[i]-1);

        return dp[i][walls] = Math.min(pick, notPick);

    }

    public static int kMax = 500_000_000;
    
    public static int[][] dp;

    public int paintWalls(int[] cost, int[] time){

        int n = cost.length;

        dp = new int[n][n + 1];

        return paintWalls(cost, time, 0, time.length);

    }

}
