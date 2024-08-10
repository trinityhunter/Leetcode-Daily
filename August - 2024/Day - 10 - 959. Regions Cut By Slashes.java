class Solution {

    int[] steps = {-1, 0, 1, 0, -1};

    public int regionsBySlashes(String[] grid) {

        int[][] graph = buildGraph(grid);

        int n = graph.length;

        int regions = 0;

        boolean[][] visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && graph[i][j] == 0){
                    regions++;
                    visited[i][j] = true;
                    dfs(graph, visited, i, j);
                }
            }
        }

        return regions;

    }

    void dfs(int[][] graph, boolean[][] visited, int r, int c){

        for(int k = 0; k < 4; k++){
            int i = r + steps[k];
            int j = c + steps[k + 1];

            if(i >= 0 && j >= 0 && i < graph.length && j < graph.length && !visited[i][j] && graph[i][j] == 0){
                visited[i][j] = true;
                dfs(graph, visited, i, j);
            }
        }

    }

    int[][] buildGraph(String[] grid){

        int n = grid.length;

        int[][] graph = new int[3*n][3*n];

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){

                char x = grid[r].charAt(c);

                if(x == '\\'){
                    for(int i = 3*r; i < 3*r + 3; i++){
                        for(int j = 3*c; j < 3*c + 3; j++){
                            if(i + 3*c == j + 3*r) graph[i][j] = 1;
                        }
                    }
                } 
                else if(x == '/'){
                    for(int i = 3*r; i < 3*r + 3; i++){
                        for(int j = 3*c; j < 3*c + 3; j++){
                            if(i + j == 3*c + 3*r + 2) graph[i][j] = 1;
                        }
                    }
                }

            }
        }

        return graph;
        
    }
}
