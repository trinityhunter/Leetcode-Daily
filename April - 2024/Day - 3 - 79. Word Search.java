class Solution {
    
    public static boolean helper(char[][] board, String word, int sr, int sc, int ind){
        
        if(ind == word.length()-1){
            return true;
        }
        
        if(sc+1 <= board[0].length-1 && board[sr][sc+1] == word.charAt(ind+1) && visited[sr][sc+1] == false){
            visited[sr][sc+1] = true;
            
            boolean right = helper(board, word, sr, sc+1, ind+1);
            
            visited[sr][sc+1] = false;
            
            if(right){
                return true;
            }
            
        }
        
        if(sc-1 >=0 && board[sr][sc-1] == word.charAt(ind+1) && visited[sr][sc-1] == false){
            visited[sr][sc-1] = true;
            
            boolean left = helper(board, word, sr, sc-1, ind+1);
            
            visited[sr][sc-1] = false;
            
            if(left){
                return true;
            }
        }
        
        if(sr+1<=board.length-1 && board[sr+1][sc] == word.charAt(ind+1) && visited[sr+1][sc] == false){
            visited[sr+1][sc] = true;
            
            boolean bottom = helper(board, word, sr+1, sc, ind+1);
            
            visited[sr+1][sc] = false;
            
            if(bottom){
                return true;
            }
        }
        
        if(sr-1 >=0 && board[sr-1][sc] == word.charAt(ind+1) && visited[sr-1][sc] == false){
            visited[sr-1][sc] = true;
            
            boolean top = helper(board, word, sr-1, sc, ind+1);
            
            visited[sr-1][sc] = false;
            
            if(top){
                return true;
            }
        }
        
        return false;
        
    }
    
    public static boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        
        visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    
                    visited[i][j] = true;
                    
                    boolean ans = helper(board, word, i, j, 0);
                    
                    visited[i][j] = false;
                    
                    if(ans){
                        return true;
                    }
                }
            }
        }
        
        return false;
        
    }
    
}
