class Solution {

    public int numMagicSquaresInside(int[][] grid) {

        int[] counter = new int[16];

        int m = grid.length;

        int n = grid[0].length;

        if(m < 3 || n < 3){
            return 0;
        }

        int numberMagicSquares = 0;

        for(int i=0; i<=m-3; i++){

            Arrays.fill(counter, 0);

            for(int j=0; j<n; j++){

                counter[grid[i][j]] += 1;
                counter[grid[i + 1][j]] += 1;
                counter[grid[i + 2][j]] += 1;

                if(j >= 3){
                    counter[grid[i][j - 3]] -= 1;
                    counter[grid[i + 1][j - 3]] -= 1;
                    counter[grid[i + 2][j - 3]] -= 1;
                }

                if(isMagicSquare(grid, counter, i, j)){
                    numberMagicSquares += 1;
                }

            }

        }

        return numberMagicSquares;

    }

    private boolean isMagicSquare(int[][] grid, int[] counter, int i, int j) {

        for(int idx=1; idx<=9; idx++){

            if(counter[idx]!=1){
                return false;
            }

        }

        for(int ix=i; ix<i+3; ix++){

            int sum = 0;

            for(int jx=j-2; jx<=j; jx++){
                sum += grid[ix][jx];
            }

            if(sum != 15){
                return false;
            }

        }

        for(int jx=j-2; jx<=j; jx++){

            int sum = 0;

            for(int ix=i; ix<i+3; ix++){
                sum += grid[ix][jx];
            }

            if(sum != 15){
                return false;
            }

        }

        if((grid[i][j - 2] + grid[i + 1][j - 1] + grid[i + 2][j]) != 15){
            return false;
        }

        if((grid[i][j] + grid[i + 1][j - 1] + grid[i + 2][j - 2]) != 15){
            return false;
        }

        return true;

    }

}
