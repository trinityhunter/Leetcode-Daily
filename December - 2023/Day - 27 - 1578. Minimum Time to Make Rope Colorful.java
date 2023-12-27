class Solution {

    public static int helper(int[] neededTime, String colors, int ind){

        if(ind == 0){
            return 0;
        }

        if(dp[ind]!=null){
            return dp[ind];
        }

        int prev = helper(neededTime, colors, ind-1);

        for(int i=ind-1; i>=0; i--){
            if(!deleted[i]){
                if(colors.charAt(i) == colors.charAt(ind)){
                    if(neededTime[i]>neededTime[ind]){
                        deleted[ind] = true;
                        return dp[ind] = neededTime[ind] + prev;
                    }
                    else{
                        deleted[i] = true;
                        return dp[ind] = neededTime[i] + prev;
                    }
                }
                else{
                    return dp[ind] = prev;
                }
            }
        }

        return dp[ind] = prev;

    }

    public static Integer[] dp;

    public static boolean[] deleted;

    public int minCost(String colors, int[] neededTime) {

        deleted = new boolean[neededTime.length];

        dp = new Integer[neededTime.length];
        
        int ans = helper(neededTime, colors, neededTime.length-1);

        return ans;

    }

}
