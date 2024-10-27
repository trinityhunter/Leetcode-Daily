class Solution {

    public int countSquares(int[][] arr) {

        // ***** Tabulation ***** - 
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        int count = 0;
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(arr[i][j] == 1){
                    count++;
                }
                
                if(i == 0){
                    dp[i][j] = 0;
                }
                else if(j == 0){
                    dp[i][j] = 0;
                }
                else{
                    int sum = 0;
                    
                    if(arr[i][j] == 1){
                        if(arr[i-1][j] == 1 && arr[i][j-1] == 1 && arr[i-1][j-1] == 1){
                            sum++;
                            sum += Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                        }
                    }
                    dp[i][j] = sum;
                }
                count += dp[i][j];
            }
        }
        
        return count;
        
    }

}
