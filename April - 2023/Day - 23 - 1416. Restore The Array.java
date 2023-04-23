class Solution {

    public static int helper(String s, long k, int i){

        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0; 
        }

        if(dp[i] != null){
            return dp[i];
        }

        int ans = 0;

        long num = 0;

        for(int j=i; j<s.length(); j++){

            num = num * 10 + s.charAt(j) - '0'; 

            if(num > k){
                break;
            }

            ans += helper(s, k, j + 1);

            ans %= 1000000007;

        }

        return dp[i] = ans;

    }

    public static Integer[] dp;

    public int numberOfArrays(String s, int k) {

        dp = new Integer[s.length()]; 

        return helper(s, k, 0);

    }
    
}
