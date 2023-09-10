class Solution {

    public static long helper(long ind){
        
        if(ind == 0){
            return 1;
        }

        if(dp[(int)ind]!=null){
            return dp[(int)ind];
        }

        long temp = helper(ind - 1) * (2 * ind-1) * ind % MOD;

        return dp[(int)ind] = temp;

    }

    public static int MOD;
    
    public static int MAX_PAIRS;
    
    public static Long[] dp;

    public int countOrders(int numPairs) {

        MOD = (int)1e9 + 7; 

        MAX_PAIRS = 510;
        
        dp = new Long[MAX_PAIRS];

        return (int)helper(numPairs);

    }

}
