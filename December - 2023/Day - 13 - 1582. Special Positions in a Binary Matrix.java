class Solution {

    public static boolean searchRow(int i, int j, int [][] mat){
        
        int count = 0;
        
        for(int x=0; x<mat.length; x++){
            count += mat[x][j];
        }
        
        if(count == 1){
            return true;
        }
        
        return false;

    }
    
    public static boolean searchCol(int i, int j, int[][] mat){
        
        int count = 0;
        
        for(int y=0; y<mat[0].length; y++){
            count += mat[i][y];
        }
        
        if(count==1){
            return true;
        }
        
        return false;

    }
    
    
    public int numSpecial(int[][] mat) {
        
        int count = 0;
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    if(searchRow(i, j, mat) && searchCol(i, j, mat)){
                        count++;
                    }
                }
            }
        }
        
        return count;

    }
    
}
