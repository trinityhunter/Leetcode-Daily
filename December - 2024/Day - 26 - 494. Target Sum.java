class Solution {

    // public static int helper(int[] nums, int ind, int target){

    //     if(ind == 0){
    //         if(target == 0 && nums[ind] == 0){
    //             return 2;
    //         }
    //         else if(target==0 || target == nums[0]){
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     if(dp[ind][target]!=null){
    //         return dp[ind][target];
    //     }

    //     int notPick = helper(nums, ind-1, target);

    //     int pick = 0;

    //     if(target-nums[ind]>=0){
    //         pick = helper(nums, ind-1, target-nums[ind]);
    //     }

    //     return dp[ind][target] = pick + notPick;

    // }

    // public static Integer[][] dp;

    public int findTargetSumWays(int[] nums, int target) {

        // ***** Memoization ***** - 

        // int sum = 0;

        // for(int i=0; i<nums.length; i++){
        //     sum += nums[i];
        // }

        // if(target>sum || (sum-target)%2!=0){
        //     return 0;
        // }

        // dp = new Integer[nums.length][(sum-target)/2 + 1];

        // int ans = helper(nums, nums.length-1, (sum-target)/2);

        // return ans;

        // ***** Tabulation ***** - 

        // int sum = 0;

        // for(int i=0; i<nums.length; i++){
        //     sum += nums[i];
        // }

        // if(target>sum || (sum-target)%2!=0){
        //     return 0;
        // }

        // int[][] dp = new int[nums.length][(sum-target)/2 + 1];

        // for(int i=0; i<nums.length; i++){
        //     for(int j=0; j<=(sum-target)/2; j++){
        //         if(i == 0){
        //             if(j == 0 && nums[i] == 0){
        //                 dp[i][j] = 2;
        //             }
        //             else if(j == 0 || j == nums[0]){
        //                 dp[i][j] = 1;
        //             }
        //             else{
        //                 dp[i][j] = 0;
        //             }
        //         }
        //         else{
        //             int notPick = dp[i-1][j];

        //             int pick = 0;

        //             if(j-nums[i]>=0){
        //                 pick = dp[i-1][j-nums[i]];
        //             }

        //             dp[i][j] = pick + notPick;
        //         }
        //     }
        // }

        // return dp[nums.length-1][(sum-target)/2];

        // ***** Space Optimized ***** - 

        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(target>sum || (sum-target)%2!=0){
            return 0;
        }

        int[] prev = new int[(sum-target)/2 + 1];

        for(int i=0; i<nums.length; i++){
            int[] curr = new int[(sum-target)/2 + 1];
            for(int j=0; j<=(sum-target)/2; j++){
                if(i == 0){
                    if(j == 0 && nums[i] == 0){
                        curr[j] = 2;
                    }
                    else if(j == 0 || j == nums[0]){
                        curr[j] = 1;
                    }
                    else{
                        curr[j] = 0;
                    }
                }
                else{
                    int notPick = prev[j];

                    int pick = 0;

                    if(j-nums[i]>=0){
                        pick = prev[j-nums[i]];
                    }

                    curr[j] = pick + notPick;
                }
            }
            prev = curr;
        }

        return prev[(sum-target)/2];
        
    }

}
