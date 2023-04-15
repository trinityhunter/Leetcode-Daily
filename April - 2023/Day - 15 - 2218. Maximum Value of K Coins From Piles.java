class Solution {

    public static int helper(List<List<Integer>> piles, int ind, int k){

        if(dp[ind][k] > 0){
            return dp[ind][k];
        }

        if(ind == piles.size()){
            return 0;
        }

        if(k == 0){
            return 0;
        }

        int ans = helper(piles, ind+1, k);
        
        int cur = 0;

        for(int j=0; j<piles.get(ind).size() && j<k; j++){

            cur += piles.get(ind).get(j);

            ans = Math.max(ans, helper(piles, ind + 1, k - j - 1) + cur);

        }

        return dp[ind][k] = ans;

    }

    public static int[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int K) {

        int n = piles.size();

        dp = new int[n+1][K+1];

        return helper(piles, 0, K);

    }

}
