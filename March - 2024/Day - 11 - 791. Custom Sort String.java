class Solution {
    
    public class Pair implements Comparable<Pair>{
        
        char key;
        int val;
        
        Pair(char key, int val){
            this.key = key;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
        
    }
    
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int ind = 1;
        
        for(int i=0; i<order.length(); i++){
            hm.put(order.charAt(i), ind);
            ind++;
        }
        
        StringBuilder temp = new StringBuilder();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                Pair p = new Pair(s.charAt(i), hm.get(s.charAt(i)));
                
                pq.add(p);
            }
            else{
                temp.append(s.charAt(i));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(pq.size()>0){
            ans.append(pq.remove().key);
        }
        
        return ans.toString() + temp.toString();
        
    }
    
}
