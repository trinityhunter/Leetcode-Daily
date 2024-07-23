class Solution {
    
    public static class Pair implements Comparable<Pair>{
        
        int key;
        int val;
        
        Pair(int key, int val){
            this.key = key;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            if(this.val == o.val){
                return o.key - this.key;
            }
            else{
                return this.val - o.val;
            }
        }
        
    }
    
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int key: hm.keySet()){
            Pair p = new Pair(key, hm.get(key));
            pq.add(p);
        }
        
        int[] arr = new int[nums.length];
        
        int ind=0;
        
        while(pq.size()>0){
            for(int i=0; i<pq.peek().val; i++){
                arr[ind] = pq.peek().key;
                ind++;
            }
            pq.remove();
        }
        
        return arr;
        
    }
    
}
