class Solution {

    public static boolean helper(int[] nums, int ind){

        if(ind >= nums.length){
            return true;
        }

        boolean ans = false;

        if(dp[ind]!=null){

            if(dp[ind] == 0){
                return false;
            }

            return true;

        }

        if(ind+1<nums.length){
            if(nums[ind] == nums[ind+1]){
                ans = ans || helper(nums, ind+2); 
            }
        }

        if(ind+2<nums.length){
            if(nums[ind] == nums[ind+1] && nums[ind+1] == nums[ind+2]){
                ans = ans || helper(nums, ind+3);
            }
        }

        if(ind+2<nums.length){
            if(nums[ind] - nums[ind+1] == -1 && nums[ind+1] - nums[ind+2] == -1){
                ans = ans || helper(nums, ind+3);
            }
        }

        dp[ind] = (ans) ? 1 : 0;

        return ans;

    }

    public static Integer[] dp;

    public boolean validPartition(int[] nums) {

        dp = new Integer[nums.length+1];

        return helper(nums, 0);

    }

}
