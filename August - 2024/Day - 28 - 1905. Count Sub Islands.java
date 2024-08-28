class Solution {
    
    public static void helper(int[][] grid1, int[][] grid2, int sr, int sc){
        
        grid2[sr][sc] = 0;
        
        if(grid1[sr][sc] == 0){
            ans = false;
        }
        
        if(sc+1<=grid2[0].length-1 && grid2[sr][sc+1] == 1){
            helper(grid1, grid2, sr, sc+1);
        }
        
        if(sc-1>=0 && grid2[sr][sc-1] == 1){
            helper(grid1, grid2, sr, sc-1);
        }
        
        if(sr+1<=grid2.length-1 && grid2[sr+1][sc] == 1){
            helper(grid1, grid2, sr+1, sc);
        }
        
        if(sr-1>=0 && grid2[sr-1][sc] == 1){
            helper(grid1, grid2, sr-1, sc);
        }
        
    }
    
    public static boolean ans;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int count = 0;
        
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    ans = true;
                    helper(grid1, grid2, i, j);
                    
                    if(ans){
                        count++;
                    }
                }
            }
        }
        
        return count;
        
    }
    
}
