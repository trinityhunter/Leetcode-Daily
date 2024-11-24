class Solution {

    public long maxMatrixSum(int[][] matrix) {

        long total = 0;
        
        boolean flag = false;

        int min = Integer.MAX_VALUE;

        for(int [] row: matrix){
            for(int i: row){

                if(i<0){
                    flag = !flag;
                }

                total += Math.abs(i);

                min = Math.min(min, Math.abs(i));

            }
        }

        if(!flag){
            return total;
        }

        return total - (2 * min);

    }

}
