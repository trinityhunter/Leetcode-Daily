class Solution {

    public static void flipRow(int[][] grid, int i){

        for(int j=0; j<grid[0].length; j++){
            if(grid[i][j] == 1){
                grid[i][j] = 0;
            }
            else{
                grid[i][j] = 1;
            }
        }

    }

    public static void flipCol(int[][] grid, int j){

        for(int i=0; i<grid.length; i++){
            if(grid[i][j] == 1){
                grid[i][j] = 0;
            }
            else{
                grid[i][j] = 1;
            }
        }

    }

    public int matrixScore(int[][] grid) {
        
        for(int i=0; i<grid.length; i++){

            if(grid[i][0] == 0){
                flipRow(grid, i);
            }

        }

        for(int j=0; j<grid[0].length; j++){

            int ones = 0;

            for(int i=0; i<grid.length; i++){
                if(grid[i][j] == 1){
                    ones++;
                }
            }

            if(ones<=grid.length/2){
                flipCol(grid, j);
            }
        }

        int ans = 0;

        for(int i=0; i<grid.length; i++){

           StringBuilder sb = new StringBuilder();

            for(int j=0; j<grid[0].length; j++){
                sb.append(grid[i][j]);
            }

            ans += Integer.parseInt(sb.toString(), 2);
        }

        return ans;

    }

}
