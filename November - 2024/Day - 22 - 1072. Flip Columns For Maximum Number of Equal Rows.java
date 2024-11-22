class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        int ans = 0;
        
        for(int i=0; i<matrix.length; i++){
            
            StringBuilder og = new StringBuilder();
            StringBuilder flipped = new StringBuilder();
            
            for(int j=0; j<matrix[0].length; j++){
                og.append(matrix[i][j]);
                
                flipped.append(matrix[i][j] == 1 ? "0" : "1");
            }
            
            hm.put(og.toString(), hm.getOrDefault(og.toString(), 0) + 1);
            hm.put(flipped.toString(), hm.getOrDefault(flipped.toString(), 0) + 1);
            
            ans = Math.max(ans, hm.get(og.toString()));
            
            ans = Math.max(ans, hm.get(flipped.toString()));
            
        }
        
        return ans;
        
    }
}
