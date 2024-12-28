class Solution {

    public static int helper(int[] values, int ind, int cap){

        if(ind >= values.length){
            if(cap == 0){
                return 0;
            }
            else{
                return Integer.MIN_VALUE;
            } 
        } 

        if(dp[ind][cap]!=null){
            return dp[ind][cap];
        }

        int notPick = helper(values, ind+1, cap);

        int pick = 0;

        if(cap == 2){
            pick = helper(values, ind+1, cap-1) + values[ind] + ind;
        }
        else if(cap == 1){
            pick = helper(values, ind+1, cap-1) + values[ind] - ind;
        }

        return dp[ind][cap] = Math.max(pick, notPick);

    }

    public static Integer[][] dp;

    public int maxScoreSightseeingPair(int[] values) {

        dp = new Integer[values.length][3];
        
        int ans = helper(values, 0, 2);

        return ans;

    }

}
