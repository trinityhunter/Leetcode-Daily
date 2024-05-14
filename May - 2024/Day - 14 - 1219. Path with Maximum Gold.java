class Solution {

    public static int helper(int[][] grid, int sr, int sc){

        if(sr<0 || sc<0 || sr>grid.length-1 || sc>grid[0].length-1 || visited[sr][sc] == true || grid[sr][sc] == 0){
            return 0;
        }

        visited[sr][sc] = true;

        int right = helper(grid, sr, sc+1);

        int bottom = helper(grid, sr+1, sc);

        int left = helper(grid, sr, sc-1);

        int top = helper(grid, sr-1, sc);

        visited[sr][sc] = false;

        return Math.max(right, Math.max(bottom, Math.max(left, top))) + grid[sr][sc];

    }

    public static boolean[][] visited;

    public int getMaximumGold(int[][] grid) {

        int max = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    visited = new boolean[grid.length][grid[0].length];
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }

        return max;

    }

}
