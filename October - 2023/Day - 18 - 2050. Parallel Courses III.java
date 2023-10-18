class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        int[] indegree = new int[n];

        for(int[] edge: relations){
            graph.get(edge[0] - 1).add(edge[1] - 1);
            indegree[edge[1] - 1]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();

        int[] maxTime = new int[n];
        
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
            maxTime[i] = time[i];
        }
        
        int node;

        while(!queue.isEmpty()){
            node = queue.remove();
            for(int neighbor: graph.get(node)){
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[node] + time[neighbor]);
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        
        int ans = 0;

        for(node=0; node<n; node++){
            ans = Math.max(ans, maxTime[node]);
        }

        return ans;
        
    }
    
}
