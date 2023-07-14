class Solution {

    // public static int helper(int[] arr, int ind, int prev, int diff){

    //     if(ind == arr.length){
    //         return 0;
    //     }

    //     if(dp[ind][prev+1]!=null){
    //         return dp[ind][prev+1];
    //     }

    //     int notPick = helper(arr, ind+1, prev, diff);

    //     int pick = 0;

    //     if(prev == -1 || arr[ind]-arr[prev] == diff){
    //         pick = 1 + helper(arr, ind+1, ind, diff);
    //     }

    //     return dp[ind][prev+1] = Math.max(pick, notPick);

    // }

    // public static Integer[][] dp;

    public int longestSubsequence(int[] arr, int difference) {

        // dp = new Integer[arr.length][arr.length+1];

        // int ans = helper(arr, 0, -1, difference);

        // return ans;

        Map<Integer, Integer> dp = new HashMap<>();

        int res = 1;

        for (int n : arr) {
            dp.put(n, dp.getOrDefault(n - difference, 0) + 1);
            res = Math.max(res, dp.get(n));
        }

        return res;

    }

}
