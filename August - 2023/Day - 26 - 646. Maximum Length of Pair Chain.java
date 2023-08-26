class Solution {

    public static int helper(int[][] pairs, int ind, int prev){

        if(ind == pairs.length){
            return 0;
        }

        if(dp[ind]!=null){
            return dp[ind];
        }

        int pick = 0;

        if(prev<pairs[ind][0]){
            pick = 1 + helper(pairs, ind+1, pairs[ind][1]);
        }

        int notPick = helper(pairs, ind+1, prev);

        return dp[ind] = Math.max(pick, notPick);

    }

    public static Integer[] dp;

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        dp = new Integer[pairs.length];
        
        int ans = helper(pairs, 0, Integer.MIN_VALUE);

        return ans;

    }

}
