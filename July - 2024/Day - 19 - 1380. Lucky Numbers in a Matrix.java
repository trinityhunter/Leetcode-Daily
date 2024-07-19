class Solution {

    public static boolean isLucky(int num, int [][] matrix, int i, int j){

        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        
        for(int x=0; x<matrix[0].length; x++){
            if(matrix[i][x]<min){
                min = matrix[i][x];
            }
        }
        
        for(int y=0; y<matrix.length; y++){
            if(matrix[y][j]>max){
                max = matrix[y][j];
            }
        }
        
        if(num == min && num == max){
            return true;
        }
        
        return false;

    }
    
    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> arr = new ArrayList<>();
  
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(isLucky(matrix[i][j], matrix, i, j)){
                    arr.add(matrix[i][j]);
                }        
            }
        }
        
        return arr;

    }
    
}
