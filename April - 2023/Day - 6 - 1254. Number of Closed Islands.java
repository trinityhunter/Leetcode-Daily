class Solution {

    public static void helper(int[][] grid, int sr, int sc){

        if(sr<0 || sc<0 || sr>grid.length-1 || sc>grid[0].length-1 || grid[sr][sc] == 1){
            return;
        }

        grid[sr][sc] = 1;

        helper(grid, sr, sc+1);
        helper(grid, sr+1, sc);
        helper(grid, sr, sc-1);
        helper(grid, sr-1, sc);

    }

    public int closedIsland(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){
            if(grid[i][0] == 0){
                helper(grid, i, 0);
            }

            if(grid[i][grid[0].length-1] == 0){
                helper(grid, i, grid[0].length-1);
            }
        }

        for(int j=0; j<grid[0].length; j++){
            if(grid[0][j] == 0){
                helper(grid, 0, j);
            }

            if(grid[grid.length-1][j] == 0){
                helper(grid, grid.length-1, j);
            }
        }

        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    helper(grid, i, j);
                    count++;
                }
            }
        }

        return count;

    }
}
