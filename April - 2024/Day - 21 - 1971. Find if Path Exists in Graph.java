class Solution {

    public static boolean helper(ArrayList<ArrayList<Integer>> adj, int sr, int sc){

        vis[sr] = true;

        if(sr == sc){
            return true;
        }

        for(int child: adj.get(sr)){
            if(!vis[child]){
                if(helper(adj, child, sc)){
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean[] vis;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++){
            
            int a = edges[i][0];

            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);

        }
        
        vis = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(helper(adj, source, destination)){
                    return true;
                }
            }
        }

        return false;

    }

}
