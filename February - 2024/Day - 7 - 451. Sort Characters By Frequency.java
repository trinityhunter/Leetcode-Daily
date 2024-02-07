class Solution {
    
    public static class Pair implements Comparable<Pair>{
        
        int key;
        int val;
        
        Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return o.val - this.val;
        }
        
    }
    
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(char key: hm.keySet()){
            Pair p = new Pair(key, hm.get(key));
            pq.add(p);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size()>0){
            for(int i=0; i<pq.peek().val; i++){
                sb.append((char)pq.peek().key);
            }
            pq.remove();
        }
        
        return sb.toString();
        
    }
}
