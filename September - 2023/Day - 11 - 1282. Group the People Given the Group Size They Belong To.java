class Solution {
    
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        List<List<Integer>> ma = new ArrayList<>();
        
        for(int i=0; i<groupSizes.length; i++){
            List<Integer> ca = new ArrayList<>();
            
            if(hm.containsKey(groupSizes[i])){
                ca = hm.get(groupSizes[i]);
            }
            
            ca.add(i);

            hm.put(groupSizes[i], ca);
            
            if(ca.size() == groupSizes[i]){
                ma.add(ca);
                hm.remove(groupSizes[i]);
            }
        }
        
        return ma;
        
    }

}
