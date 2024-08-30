class Solution {

    List<int[]>[] graph;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

        graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){

            int[] e = edges[i];

            graph[e[0]].add(new int[]{e[1], i});

            graph[e[1]].add(new int[]{e[0], i});

        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2)->v1[1]-v2[1]);

        pq.add(new int[]{destination, 0});

        Integer[] distances = new Integer[n];
        
        while(!pq.isEmpty()){

            int[] c = pq.poll();

            if(distances[c[0]] != null){
                continue;
            }

            distances[c[0]] = c[1];

            if(c[0] == source){
                continue;
            }

            for(int[] e: graph[c[0]]){

                if(distances[e[0]] != null){
                    continue;
                }

                pq.add(new int[]{e[0], c[1]+Math.abs(edges[e[1]][2])});

            }

        }

        if(distances[source] > target){
            return new int[][]{};
        }

        pq = new PriorityQueue<>((v1, v2)->v1[1]-v2[1]);

        if(distances[source] != target){
            pq.add(new int[]{source, 0});
        }
        
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){

            int[] c = pq.poll();

            if(visited[c[0]]){
                continue;
            }

            visited[c[0]] = true;

            if(c[0] == destination){
                return new int[][]{};
            }

            for(int[] e : graph[c[0]]){

                if(visited[e[0]] || distances[e[0]] == null){
                    continue;
                }
                
                int dif = target - c[1] - distances[e[0]];

                if(Math.abs(edges[e[1]][2]) >= dif){
                    continue;
                }

                if(edges[e[1]][2] == -1){
                    edges[e[1]][2] = dif;
                    continue;
                }

                pq.add(new int[] {e[0], c[1]+edges[e[1]][2]});

            }

        }

        for(int[] e : edges){

            if(e[2] == -1){
                e[2] = 1;
            }

        }

        return edges;

    }
    
}
