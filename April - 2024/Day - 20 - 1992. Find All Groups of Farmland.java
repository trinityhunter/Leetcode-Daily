class Solution {
    
    public static void helper(int[][] grid, int sr, int sc){
        
        grid[sr][sc] = 0;
        
        er = Math.max(sr, er);
        ec = Math.max(sc, ec);
        
        if(sc+1<=grid[0].length-1 && grid[sr][sc+1] == 1){
            helper(grid, sr, sc+1);
        }
        
        if(sr+1<=grid.length-1 && grid[sr+1][sc] == 1){
            helper(grid, sr+1, sc);
        }
        
    }
    
    public static int er;
    
    public static int ec;
    
    public int[][] findFarmland(int[][] land) {
        
        List<int[]> ma = new ArrayList<>();
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1){
                    
                    er = i;
                    ec = j;
                    
                    helper(land, i, j);
                    
                    ma.add(new int[]{i, j, er, ec});
                }
            }
        }
        
        return ma.toArray(new int[0][0]);
        
    }
  
}
