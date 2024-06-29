class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
        }

        for(int node=0; node<n; node++){
            boolean visited[] = new boolean[n];
            visited[node] = true;
            dfs(node, res, node, visited, adjList);
        }

        return res;

    }

    public void dfs(
        int curr, 
        List<List<Integer>> res,
        int source,
        boolean visited[],
        List<List<Integer>> adjList
    ){
        for(int dest: adjList.get(curr)){
            if(!visited[dest]){
                visited[dest] = true;
                res.get(dest).add(source);
                dfs(dest,res,source,visited,adjList);
            }
        }

    }
    
}
