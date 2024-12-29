class Solution {

    public static long helper(String[] words, String target, int i, int j){

        if(j==target.length()){
            return 1;
        }

        if(i == words[0].length() || words[0].length() - i < target.length() - j){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        long ans = 0;

        for(int ind=0; ind<words.length; ind++){
            if(words[ind].charAt(i) == target.charAt(j)){
                ans += helper(words, target, i+1, j+1)%1000000007;
            }
        }

        ans += helper(words, target, i+1, j)%1000000007;

        return dp[i][j] = ans%1000000007;

    }

    public static Long[][] dp;

    public int numWays(String[] words, String target) {

        dp = new Long[words[0].length()][target.length()];
        
        long ans = helper(words, target, 0, 0);

        return (int)ans%1000000007;
        
    }

}
