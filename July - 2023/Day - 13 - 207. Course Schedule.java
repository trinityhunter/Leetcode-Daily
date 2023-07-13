class Solution {
    
    public boolean canFinish(int N, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i =0;i<N;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i =0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int [] indegree = new int[N];
        
        for(ArrayList<Integer> list : graph){
            for(int x:list){
                indegree[x]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i =0;i<N;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        
        while(q.size()>0){
            
            int front = q.remove();
            topo.add(front);
            
            for(int x:graph.get(front)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.add(x);
                }
            }
        }
        
        return (topo.size()==N?true:false);

    }

}
