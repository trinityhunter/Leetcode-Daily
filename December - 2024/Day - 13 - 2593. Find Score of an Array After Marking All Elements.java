class Pair implements Comparable<Pair>{

    int val;

    int ind;
    
    public Pair(int val,int ind){
        this.val = val;
        this.ind = ind;
    }
    
    public int compareTo(Pair o){

        if(this.val == o.val){
            return this.ind - o.ind;
        }

        return this.val - o.val;

    }

}

class Solution {

    public long findScore(int[] nums) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++){
            pq.add(new Pair(nums[i],i));
        }
        
        boolean[] vis = new boolean[nums.length];
        
        long ans = 0;
        
        while(!pq.isEmpty()){
            
            Pair rem = pq.remove();
            
            if(!vis[rem.ind]){
                
                ans += rem.val;

                vis[rem.ind] = true;
                
                if(rem.ind-1>=0 && vis[rem.ind-1] == false){
                    vis[rem.ind-1] = true;
                }
                
                if(rem.ind+1<nums.length && vis[rem.ind+1] == false){
                    vis[rem.ind+1] = true;
                }
                
            }
            
        }
        
        return ans;
        
    }

}
