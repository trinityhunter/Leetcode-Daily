class Graph {
    int adjmatrix[][];
    public Graph(int n, int[][] edges) {
        adjmatrix=new int[n][n];
        Arrays.stream(adjmatrix).forEach(row->Arrays.fill(row,(int)1e9));
        for(int edge[]:edges){
            adjmatrix[edge[0]][edge[1]]=edge[2];
        }
        for(int i=0;i<n;i++){
            adjmatrix[i][i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    adjmatrix[j][k]=Math.min(adjmatrix[j][k],adjmatrix[j][i]+adjmatrix[i][k]);
                }
            }
        }
        
    }
    
    public void addEdge(int[] edge) {
        int n=adjmatrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjmatrix[i][j]=Math.min(adjmatrix[i][j],adjmatrix[i][edge[0]]+adjmatrix[edge[1]][j]+edge[2]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        if(adjmatrix[node1][node2]==(int)1e9){
            return -1;
        }
        return adjmatrix[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
