class Solution {

    public static int helper(String str, int ind, int prev, int k){

        if(ind >= str.length()){
            return 0;
        }

        if(dp[ind][prev+1]!=null){
            return dp[ind][prev+1];
        }

        int notPick = helper(str, ind+1, prev, k);

        int pick = 0;

        if(prev == -1 || (int)(Math.abs((str.charAt(ind) - 'a') - prev))<=k){
            pick = helper(str, ind+1, str.charAt(ind)-'a', k) + 1;
        }

        return dp[ind][prev+1] = Math.max(pick, notPick);

    }

    public static Integer[][] dp;

    public int longestIdealString(String s, int k) {

        dp = new Integer[s.length()][28];
        
        int ans = helper(s, 0, -1, k);

        return ans;

    }

}
