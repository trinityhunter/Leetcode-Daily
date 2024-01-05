class Solution {

    // public static int helper(int[] nums, int ind, int prev){

    //     if(ind == nums.length-1){
    //         if(prev == -1 || nums[ind]>nums[prev]){
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     if(dp[ind][prev+1]!=null){
    //         return dp[ind][prev+1];
    //     }

    //     int notPick = helper(nums, ind+1, prev);

    //     int pick = 0;

    //     if(prev == -1 || nums[ind]>nums[prev]){
    //         pick = 1 + helper(nums, ind+1, ind);
    //     }

    //     return dp[ind][prev+1] = Math.max(pick, notPick);

    // }

    // public static Integer[][] dp;

    public int lengthOfLIS(int[] nums) {

        // ***** Memoization ***** - 

        // dp = new Integer[nums.length][nums.length+1];

        // int ans = helper(nums, 0, -1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[nums.length][nums.length+1];

        // for(int i=nums.length-1; i>=0; i--){
        //     for(int j=nums.length-1; j>=-1; j--){
        //         if(i == nums.length-1){
        //             if(j == -1 || nums[i]>nums[j]){
        //                 dp[i][j+1] = 1;
        //             }
        //             else{
        //                 dp[i][j+1] = 0;
        //             }
        //         }
        //         else{
        //             int notPick = dp[i+1][j+1];

        //             int pick = 0;

        //             if(j == -1 || nums[i]>nums[j]){
        //                 pick = 1 + dp[i+1][i+1];
        //             }

        //             dp[i][j+1] = Math.max(pick, notPick);
        //         }
        //     }
        // }

        // return dp[0][0];

        // ***** Space Optimized ***** - 

        int[] next = new int[nums.length+1];

        for(int i=nums.length-1; i>=0; i--){
            int[] curr = new int[nums.length+1];
            for(int j=nums.length-1; j>=-1; j--){
                if(i == nums.length-1){
                    if(j == -1 || nums[i]>nums[j]){
                        curr[j+1] = 1;
                    }
                    else{
                        curr[j+1] = 0;
                    }
                }
                else{
                    int notPick = next[j+1];

                    int pick = 0;

                    if(j == -1 || nums[i]>nums[j]){
                        pick = 1 + next[i+1];
                    }

                    curr[j+1] = Math.max(pick, notPick);
                }
            }
            next = curr;
        }

        return next[0];

    }

}
