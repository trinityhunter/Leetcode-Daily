class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        
        int tle = matrix.length * matrix[0].length;
        
        int sr = 0, sc = 0;

        int er = matrix.length-1, ec = matrix[0].length-1;
        
        int dir = -1;
        
        List<Integer> arr = new ArrayList<>();
        
        while(tle!=0){
            
            dir = (dir + 1)%4;
            
            if(dir == 0){
                for(int i=sc; i<=ec; i++){
                    arr.add(matrix[sr][i]);
                    tle--;
                }
                sr++;
            }
            else if(dir == 1){
                for(int i=sr; i<=er; i++){
                    arr.add(matrix[i][ec]);
                    tle--;
                }
                ec--;
            }
            else if(dir == 2){
                for(int i=ec; i>=sc; i--){
                    arr.add(matrix[er][i]);
                    tle--;
                }
                er--;
            }
            else{
                for(int i=er; i>=sr; i--){
                    arr.add(matrix[i][sc]);
                    tle--;
                }
                sc++;
            }
            
        }
        
        return arr;
        
    }

}
