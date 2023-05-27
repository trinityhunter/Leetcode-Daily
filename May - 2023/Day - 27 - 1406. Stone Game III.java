class Solution {

    public static int helper(int stones[], int ind, int player){
        
        if(ind>=stones.length){
            return 0;
        }

        if(dp[ind][player]!=null){
            return dp[ind][player];
        }

        int max = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;

        int sum = 0;

        for(int i=0; i<3; i++){

            if(ind+i == stones.length){
                break;
            }

            sum += stones[ind+i];

            int ans = 0;

            if(player == 1){
                ans = sum + helper(stones, ind+i+1, 0);
            }
            else{
                ans = -sum + helper(stones, ind+i+1, 1);
            }

            max = Math.max(max, ans);

            min = Math.min(min, ans);

        }

        if(player == 1){
            return dp[ind][player] = max;
        }
        else{
            return dp[ind][player] = min;
        } 

    }

    public static Integer dp[][];

    public String stoneGameIII(int[] stoneValue) {

        dp = new Integer[stoneValue.length][2];

        int ans = helper(stoneValue, 0, 1);

        if(ans == 0){
            return "Tie";
        } 
        else if(ans > 0){
            return "Alice";
        }
        else{
            return "Bob";
        }

    }
    
}
