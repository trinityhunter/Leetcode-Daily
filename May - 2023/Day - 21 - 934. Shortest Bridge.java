class Solution {

    public static void helper(int i, int j, Queue<int[]> q, int[][] grid){

        if(i<0 || i==row || j<0 || j==col || grid[i][j]!=1){
            return;
        }
        
        grid[i][j] = -1;
        
        q.add(new int[]{i, j, 0});
        helper(i+1, j, q, grid);
        helper(i-1, j, q, grid);
        helper(i, j+1, q, grid);
        helper(i, j-1, q, grid);

    }

    public static int row;
    
    public static int col;

    public int shortestBridge(int[][] grid){

        row = grid.length;

        col = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<row && q.isEmpty(); i++){
            for (int j=0; j<col && q.isEmpty(); j++) {
                if(grid[i][j]==1){
                    helper(i, j, q, grid);
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(q.isEmpty()==false){

            int[] cur = q.remove();

            for(int[] dir: dirs){

                int i = cur[0] + dir[0], j = cur[1] + dir[1];

                if(i<0 || i==row || j<0 || j==col || grid[i][j] == -1){
                    continue;
                }

                if(grid[i][j]==1){
                    return cur[2];
                }

                grid[i][j] = -1;

                q.add(new int[]{i, j, cur[2]+1});

            }

        }

        return -1;

    }
    
}
