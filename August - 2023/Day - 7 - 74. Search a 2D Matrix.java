class Solution {

    public static boolean helper (int[][] matrix, int row, int target){

        int left = 0;

        int right = matrix[row].length - 1;

        while(left <= right){

            int mid = (left + right)/2;

            if(matrix[row][mid] < target){
                left = mid + 1;
            }
            else if(matrix[row][mid] > target){
                right = mid - 1;
            }
            else{
                return true;
            }

        }

        return false;

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0){
            return false;
        }

        int i = 0;

        int last = matrix.length-1;

        int j = matrix[0].length-1;

        while(i<=last){
            int mid = (i+last)/2;

            if(matrix[mid][0]<=target && matrix[mid][j] >= target){
                return helper(matrix, mid, target);
            }
            if(matrix[mid][j] < target){
                i = mid+1;
            }
            if(matrix[mid][0] > target){
                last = mid-1;
            }
        }

        return false;

    }

}
