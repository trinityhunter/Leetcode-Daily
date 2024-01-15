class Solution {
    
    public List<List<Integer>> findWinners(int[][] matches) {
        
        List<List<Integer>> arr = new ArrayList<>();
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<matches.length; i++){
            
            if(!hm.containsKey(matches[i][0])){
                hm.put(matches[i][0], 0);
            }
            
            if(hm.containsKey(matches[i][1])){
                hm.put(matches[i][1], hm.get(matches[i][1]) + 1);
            }
            else{
                hm.put(matches[i][1], 1);
            }
            
        }
        
        List<Integer> winners = new ArrayList<>();
        
        List<Integer> almostWinners = new ArrayList<>();
        
        for(int key: hm.keySet()){
            if(hm.get(key) == 0){
                winners.add(key);
            }
            else if(hm.get(key) == 1){
                almostWinners.add(key);
            }
        }
        
        Collections.sort(winners);
        Collections.sort(almostWinners);
        
        arr.add(winners);
        
        arr.add(almostWinners);
        
        // System.out.println(hm);
        
        return arr;
        
    }
    
}
