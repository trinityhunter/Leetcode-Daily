class Solution {

    public int[][] largestLocal(int[][] grid) {

        int n = grid.length;

        int[][] result = new int[n-2][n -2];

        int windowMax;   

        for(int row=0; row< n; row++){
            windowMax = Integer.MIN_VALUE;  
            for (int i = 0; i <= n - 3; i++) {
                for (int j = i; j < i + 3; j++) {
                    windowMax= Math.max(windowMax, grid[row][j]);
                }
                grid[row][i] = windowMax;
                windowMax = Integer.MIN_VALUE;  
            }
        }

        for(int col=0; col< n - 2; col++){
            windowMax = Integer.MIN_VALUE;
            for (int i = 0; i <= n - 3; i++) {
                for (int j = i; j < i + 3; j++) {
                    windowMax= Math.max(windowMax, grid[j][col]); 
                }
                result[i][col] = windowMax;
                windowMax = Integer.MIN_VALUE;  
            }
        }

        return result;

    }
    
}
