class Solution {

    int index;
    int res[][];

    private void helper(int r, int c, int R, int C){
      
        if(r >= R || r < 0 || c >= C || c < 0){
            return;
        }

        res[index][0] = r;

        res[index++][1] = c;

    }

    public int[][] spiralMatrixIII(int R, int C, int rStart, int cStart) {

        int r = rStart, c = cStart;

        int length = 1;

        res = new int[R * C][2];

        while(index < (R * C)){

            for(int i=0; i<length; i++){
                helper(r, c++, R, C);
            }

            for(int i=0; i<length; i++){
                helper(r++, c, R, C);
            }

            length++;
            
            for(int i=0; i<length; i++){
                helper(r, c--, R, C);
            }

            for(int i=0; i<length; i++){
                helper(r--, c, R, C);
            }

            length++;

        }

        return res;

    }
    
}
