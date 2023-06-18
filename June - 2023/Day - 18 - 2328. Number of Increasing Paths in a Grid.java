class Solution {
    
    public static int helper(int[][] matrix, int sr, int sc){
        
        long max = 0;
        
        if(sc+1<=matrix[0].length-1 && matrix[sr][sc+1] > matrix[sr][sc]){
            
            if(dp[sr][sc+1]!=0){
                max += dp[sr][sc+1];
            }
            else{
                int temp = helper(matrix, sr, sc+1);
                dp[sr][sc+1] = temp%1000000007;
                max += temp;
            }
            
        }
        
        if(sc-1>=0 && matrix[sr][sc-1] > matrix[sr][sc]){
            
            if(dp[sr][sc-1]!=0){
                max += dp[sr][sc-1];
            }
            else{
                int temp = helper(matrix, sr, sc-1);
                dp[sr][sc-1] = temp%1000000007;
                max += temp;
            }
            
        }
        
        if(sr+1<=matrix.length-1 && matrix[sr+1][sc] > matrix[sr][sc]){
            
            if(dp[sr+1][sc]!=0){
                max += dp[sr+1][sc];
            }
            else{
                int temp = helper(matrix, sr+1, sc);
                dp[sr+1][sc] = temp%1000000007;
                max += temp;
            }
            
        }
        
        if(sr-1>=0 && matrix[sr-1][sc] > matrix[sr][sc]){
            
            if(dp[sr-1][sc]!=0){
                max += dp[sr-1][sc];
            }
            else{
                int temp = helper(matrix, sr-1, sc);
                dp[sr-1][sc] = temp%1000000007;
                max += temp;
            }
            
        }
        
        max++;
        
        max = max % 1000000007;
        
        return (int) max;
        
    }
    
    public static int[][] dp;
    
    public int countPaths(int[][] matrix) {
        
        long mod=1000000007;
        
        dp = new int[matrix.length][matrix[0].length];
        
        long max = 0;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                max += helper(matrix, i, j)%mod;
            }
        }
        
        max = max % mod;
        
        return (int)max;
        
    }
    
}
