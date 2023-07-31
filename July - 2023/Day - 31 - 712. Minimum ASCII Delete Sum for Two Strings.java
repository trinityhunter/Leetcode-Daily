class Solution {

    public static int getSum(String s, int n){

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += s.charAt(i);
        }

        return sum;

    }

    public static int helper(String s1, String s2, int n, int m){

        if(n == 0){
            return dp[n][m] = getSum(s2, m);
        }

        if(m == 0){
            return dp[n][m] = getSum(s1, n);
        }

        if(dp[n][m]!=null){
            return dp[n][m];
        }

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = helper(s1, s2, n-1, m-1);
        }
        else{

            int ans1 = s1.charAt(n-1) + helper(s1, s2, n-1, m);

            int ans2 = s2.charAt(m-1) + helper(s1, s2, n, m-1);

            return dp[n][m] = Math.min(ans1, ans2);

        }

    }

    public static Integer[][] dp;

    public int minimumDeleteSum(String s1, String s2) {

        dp = new Integer[s1.length()+1][s2.length()+1];

        int ans = helper(s1, s2, s1.length(), s2.length());

        return ans;

    }
    
}
