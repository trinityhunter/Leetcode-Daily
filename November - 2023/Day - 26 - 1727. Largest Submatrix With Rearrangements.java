class Solution {

    public int largestSubmatrix(int[][] matrix) {

        int rows = matrix.length;

        int cols = matrix[0].length;

        for(int col=0; col<cols; col++) {
            for(int row=1; row<rows; row++) {
                if(matrix[row][col]!=0) {
                    matrix[row][col] += matrix[row-1][col];
                }
            }
        }

        int maxArea = 0;

        for(int row=0; row<rows; row++) {
            Arrays.sort(matrix[row]);
            int n = matrix[row].length;
            for(int i=n-1; i>=0; i--) {
                if(matrix[row][i] == 0){
                    break;
                }
                int area = (n-i) * matrix[row][i];
                maxArea = Integer.max(maxArea, area);
            }
        }

        return maxArea;

    }
    
}
