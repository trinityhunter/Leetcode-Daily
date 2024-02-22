class Solution {

    public int findJudge(int n, int[][] trust) {

        if(n == 1){
            return 1;
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<trust.length; i++){
            hm.put(trust[i][0], hm.getOrDefault(trust[i][0],0) + (-1));
            hm.put(trust[i][1], hm.getOrDefault(trust[i][1],0) + 1);
        }
        
        for(int key: hm.keySet()){
            if(hm.get(key) == n-1){
                return key;
            }
        }
        
        return -1;
        
    }
    
}
