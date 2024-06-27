class Solution {

    public int findCenter(int[][] edges) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<edges.length; i++){
            for(int j=0; j<2; j++){
                hm.put(edges[i][j], hm.getOrDefault(edges[i][j], 0) + 1);
                if(hm.get(edges[i][j]) == edges.length){
                    return edges[i][j];
                }
            }
        }

        return 0;

    }
    
}
