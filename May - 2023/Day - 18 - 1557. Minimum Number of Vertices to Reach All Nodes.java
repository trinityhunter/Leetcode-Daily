class Solution {
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> ans = new ArrayList<>();
        
        boolean[] inDegree = new boolean[n];
        
        for(int i=0; i<edges.size(); i++){
            inDegree[edges.get(i).get(1)] = true;
        }
        
        for(int i=0; i<inDegree.length; i++){
            if(!inDegree[i]){
                ans.add(i);
            }
        }
        
        return ans;

    }

}
