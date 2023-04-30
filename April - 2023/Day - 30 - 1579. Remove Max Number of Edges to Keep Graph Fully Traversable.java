class Solution {

    public static int countEdges(int type, Set<String> set, Set<Integer> nodes, int[][] edges){

        int count = 0;

        for(int[] edge: edges){

            if (edge[0] == type){
                continue;
            }

            int a = edge[1];
            
            int b = edge[2];

            nodes.add(a); nodes.add(b);

            if(edge[0] == 3 && set.contains(a + "-" + b)){
                continue;
            }

            count++;

        }

        return count;

    }

    public static int dfs(HashMap<Integer, List<Integer>> map, int[] visited, int node, int depth, Set<String> removedEdges) {

        int count = 0;

        visited[node] = depth;

        for(int next: map.getOrDefault(node, new ArrayList<>())){

            if(visited[next] == 0){
                count += dfs(map, visited, next, depth + 1, removedEdges);
            } 
            else if(visited[next] == depth - 1){
                continue;
            } 
            else if(!removedEdges.contains(node + "-" + next)){
                removedEdges.add(node + "-" + next); removedEdges.add(next + "-" + node);
                count++;
            }

        }

        return count;

    }

    public static int helper(int[][] edges, int n, Set<String> set) {

        int count = 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge: edges){

            if(edge[0] != 3){
                continue;
            }

            int a = edge[1];

            int b = edge[2];

            map.computeIfAbsent(a, f -> new ArrayList<>()).add(b);

            map.computeIfAbsent(b, f -> new ArrayList<>()).add(a);

        }


        int[] visited = new int[n+1];

        for(int i=1; i<=n; i++){

            if(visited[i] != 0){
                continue;
            }

            count += dfs(map, visited, i, 1, set);

        }

        return count;

    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int ans = 0;
        
        Set<String> set = new HashSet<>();

        ans += helper(edges, n, set);
        
        Set<Integer> nodes = new HashSet<>();

        int count = countEdges(2, set, nodes, edges);

        if(count<n-1 || nodes.size()<n){
            return -1;
        }

        ans += (count-(n-1));
        
        nodes = new HashSet<>();

        count = countEdges(1, set, nodes, edges);

        if(count<n-1 || nodes.size()<n){ 
            return -1;
        }

        ans += (count-(n-1));

        return ans;

    }

}
