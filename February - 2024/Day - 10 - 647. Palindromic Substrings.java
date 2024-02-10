class Solution {

    public static boolean isPalindrome(String str){

        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }

        return true;

    }

    public static int helper(String s, int ind){

        if(ind == 0){
            return 1;
        }

        if(dp[ind]!=null){
            return dp[ind];
        }

        int count = 0;

        for(int i=ind-1; i>=0; i--){
            if(isPalindrome(s.substring(i, ind+1))){
                count++;
            }
        }

        return dp[ind] = helper(s, ind-1) + count + 1;

    }

    public static Integer[] dp;

    public int countSubstrings(String s) {

        dp = new Integer[s.length()];
        
        int ans = helper(s, s.length()-1);

        return ans;

    }

}
