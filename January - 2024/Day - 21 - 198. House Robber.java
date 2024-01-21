class Solution {

    // public static int helper(int[] nums, int ind){

    //     if(ind<0){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     int nopick = helper(nums, ind-1);

    //     int pick = nums[ind] + helper(nums, ind-2);

    //     return dp[ind] = Math.max(pick, nopick);

    // }

    // public static Integer[] dp;

    public int rob(int[] nums) {

        // ***** Memoization ***** - 

        // dp = new Integer[nums.length];

        // return helper(nums, nums.length-1);

        // ***** Tabulation ***** - 

        // int[] dp = new int[nums.length];

        // for(int i=0; i<nums.length; i++){
        //     if(i == 0){
        //         dp[i] = nums[i];
        //     }
        //     else if(i==1){
        //         dp[i] = Math.max(dp[i-1], nums[i]);
        //     }
        //     else{
        //         int notPick = dp[i-1];
        
        //         int pick = nums[i] + dp[i-2];
                
        //         dp[i] = Math.max(pick, notPick);
        //     }
        // }

        // return dp[nums.length-1];

        // ***** Space Optimized ***** - 

        int ans = nums[0];

        int prev = nums[0];

        int prevprev = 0;

        for(int i=1; i<nums.length; i++){
            int notPick = prev;
    
            int pick = nums[i] + prevprev;
            
            ans = Math.max(pick, notPick);
            prevprev = prev;
            prev = ans;
        }

        return ans;
        
    }

}
