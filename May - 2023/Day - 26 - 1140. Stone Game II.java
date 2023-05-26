class Solution {

    public static int helper(int[] piles, int ind, int M){

        if(ind == piles.length){
            return 0;
        }
        
        if(dp[ind][M] != null){
            return dp[ind][M];
        }
        
        int maxScore = Integer.MIN_VALUE;
        
        int stone = 0;
        
        for(int x=0; x<2*M; x++){

            int i = ind + x;
            
            if(i>=piles.length){
                continue;
            }
            
            stone += piles[i];
            
            int score = stone - helper(piles, i + 1, Math.max(x + 1, M));
            
            maxScore = Math.max(maxScore, score);

        }
        
        return dp[ind][M] = maxScore;

    }
    
    public static Integer[][] dp;
    
    public int stoneGameII(int[] piles) {
        
        dp = new Integer[piles.length][piles.length * 2];
        
        int ans = 0;

        for(int stones: piles){
            ans += stones;
        }
        
        return (ans + helper(piles, 0, 1))/2;
    
    }
    
}
