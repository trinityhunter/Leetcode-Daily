class Solution {

    public static int helper(String x, String y, int m, int n){

        if(n == y.length()){
            return 0;
        }

        if(dp[m][n]!=null){
            return dp[m][n];
        }

        int min = Integer.MAX_VALUE;

        int count = 0;

        int k = m;

        while(x.charAt(k)!=y.charAt(n)){
            k = (k+1)%x.length();
            count++;
        }

        min = Math.min(min, helper(x, y, k, n+1) + count + 1);

        count = 0;

        k = m;

        while(x.charAt(k)!=y.charAt(n)){
            if(--k<0){
                k = x.length()-1;
            }
            count++;
        }

        min = Math.min(min, helper(x, y, k, n+1) + count + 1);

        return dp[m][n] = min;

    }

    public static Integer[][] dp;

    public int findRotateSteps(String ring, String key) {

        dp = new Integer[ring.length()][key.length()];

        int ans = helper(ring, key, 0, 0);

        return ans;

    }

}
