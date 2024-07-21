class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        int[][] arr = new int[rowSum.length][colSum.length];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(rowSum[i] == 0 || colSum[j] == 0){
                    arr[i][j] = 0;
                }
                else{
                    int min = Math.min(rowSum[i], colSum[j]);
                    arr[i][j] = min;
                    rowSum[i] -= min;
                    colSum[j] -= min;
                }
            }
        }

        return arr;

    } 

}
