class Solution {

    public static void helper(char[][] grid, int sr, int sc){

        if(sr>grid.length-1 || sc>grid[0].length-1 || sr<0 || sc<0 || vis[sr][sc] == true || grid[sr][sc] == '0'){
            return;
        }

        vis[sr][sc] = true;

        helper(grid, sr, sc+1);
        helper(grid, sr+1, sc);
        helper(grid, sr, sc-1);
        helper(grid, sr-1, sc);

    }

    public static boolean[][] vis;

    public int numIslands(char[][] grid) {
        
        vis = new boolean[grid.length][grid[0].length];

        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] =='1' && !vis[i][j]){
                    helper(grid, i, j);
                    count++;
                }
            }
        }

        return count;

    }

}
