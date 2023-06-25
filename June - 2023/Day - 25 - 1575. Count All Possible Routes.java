class Solution {

    public static int helper(int[] locations, int start, int finish, int fuel){

        if(dp[start][fuel]!=null){
            return dp[start][fuel];
        }

        int ans = 0;

        if(start == finish){
            ans++;
        }

        for(int i=0; i<locations.length; i++){
            if(start != i && fuel - Math.abs(locations[start] - locations[i]) >= 0){
                ans = (ans + helper(locations, i, finish, fuel - Math.abs(locations[start] - locations[i])))%1000000007;
            }
        }

        return dp[start][fuel] = ans%1000000007;

    }

    public static Integer[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        // ***** Memoization ***** - 

        dp = new Integer[locations.length][fuel+1];

        int ans = helper(locations, start, finish, fuel);

        return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[locations.length][fuel+1];

        // Arrays.fill(dp[finish],1);

        // for(int j = 0; j <= fuel; j++) {
        //     for(int i = 0; i < locations.length; i++) {
        //         for(int k = 0; k < locations.length; k++) {
        //             if(k == i) continue;
        //             if(Math.abs(locations[i] - locations[k]) <= j) {
        //                 dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])])%1000000007; 
        //             }
        //         }
        //     }
        // }

        // return dp[start][fuel];

    }

}
