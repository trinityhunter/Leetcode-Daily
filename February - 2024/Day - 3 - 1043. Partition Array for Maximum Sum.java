class Solution {

    // public static int helper(int[] nums, int ind, int k){

    //     if(ind == nums.length){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     int len = 0;

    //     int maxi = Integer.MIN_VALUE;

    //     int max = Integer.MIN_VALUE;

    //     for(int j=ind; j<Math.min(ind+k, nums.length); j++){
    //         len++;

    //         maxi = Math.max(maxi, nums[j]);

    //         int sum = len * maxi + helper(nums, j+1, k);

    //         max = Math.max(max, sum);
    //     }

    //     return dp[ind] = max;

    // }

    // public static Integer[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {

        // ***** Memoization ***** - 

        // dp = new Integer[arr.length];
        
        // int ans = helper(arr, 0, k);

        // return ans;

        // ***** Tabulation ***** - 

        int[] dp = new int[arr.length+1];

        for(int ind=arr.length-1; ind>=0; ind--){
            int len = 0;

            int maxi = Integer.MIN_VALUE;

            int max = Integer.MIN_VALUE;

            for(int j=ind; j<Math.min(ind+k, arr.length); j++){
                len++;

                maxi = Math.max(maxi, arr[j]);

                int sum = len * maxi + dp[j+1];

                max = Math.max(max, sum);
            }

            dp[ind] = max;
        }

        return dp[0];

    }

}
