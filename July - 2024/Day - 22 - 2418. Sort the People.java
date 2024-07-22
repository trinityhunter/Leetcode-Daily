class Solution {
    
    public static class Pair implements Comparable<Pair>{
        
        String name;
        int height;
        
        Pair(String name, int height){
            
            this.name = name;
            this.height = height;
            
        }
        
        public int compareTo(Pair o){
            return this.height - o.height;
        }
        
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<names.length; i++){
            Pair p = new Pair(names[i], heights[i]);
            pq.add(p);
        }
        
        String[] arr = new String[names.length];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = pq.remove().name;
        }
        
        return arr;
        
    }
}
