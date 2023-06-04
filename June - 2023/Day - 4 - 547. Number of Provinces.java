class Solution {

    public static void helper(int node, ArrayList<ArrayList<Integer>> adj){

        vis[node] = 1;

        for(int child: adj.get(node)){
            if(vis[child] == 0){
                helper(child, adj);
            }
        }

    }

    public static int[] vis;

    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<isConnected.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        vis = new int[isConnected.length];

        int count = 0;

        for(int i=0; i<isConnected.length; i++){
            if(vis[i] == 0){
                helper(i, adj);
                count++;
            }
        }

        return count;

    }

}
