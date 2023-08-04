class Solution {

    public static boolean helper(String s, HashSet<String> set, int ind){

        if(ind == s.length()){
            return true;
        }

        if(dp[ind]!=null){
            return dp[ind];
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=ind; i<s.length(); i++){
            sb.append(s.charAt(i));
            if(set.contains(sb.toString()) && helper(s, set, i+1)){
                return dp[ind] = true;
            }
        }

        return dp[ind] = false;

    }

    public static Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        dp = new Boolean[s.length()];
        
        boolean ans = helper(s, set, 0);

        return ans;

    }

}
