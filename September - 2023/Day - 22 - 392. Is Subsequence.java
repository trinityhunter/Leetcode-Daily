class Solution {

    public static String helper(String s, String t, int ind1, int ind2){

        if(ind1<0 || ind2<0){
            return "";
        }

        if(dp[ind1][ind2]!=null){
            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == t.charAt(ind2)){
            return dp[ind1][ind2] = helper(s, t, ind1-1, ind2-1) + s.charAt(ind1);
        }

        String str1 = helper(s, t, ind1-1, ind2);

        String str2 = helper(s, t, ind1, ind2-1);

        if(str1.length()>str2.length()){
            return dp[ind1][ind2] = str1;
        }

        return dp[ind1][ind2] = str2;

    }

    public static String[][] dp;

    public boolean isSubsequence(String s, String t) {

        dp = new String[s.length()][t.length()];

        String ans = helper(s, t, s.length()-1, t.length()-1);

        if(s.equals(ans)){
            return true;
        }

        return false;

    }

}
