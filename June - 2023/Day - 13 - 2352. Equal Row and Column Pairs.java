class Solution {

    public int equalPairs(int[][] grid) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<grid.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid[0].length; j++){
                sb.append(grid[i][j]);
                sb.append(",");
            }
            String str = sb.toString();
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        
        int count = 0;
        
        for(int j=0; j<grid[0].length; j++){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<grid.length; i++){
                sb.append(grid[i][j]);
                sb.append(",");
            }
            String str = sb.toString();
            if(hm.containsKey(str)){
                count += hm.get(str);
            }
        }
        
        return count;
        
    }
    
}
