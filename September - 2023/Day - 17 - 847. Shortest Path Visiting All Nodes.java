class Solution {

    public int shortestPathLength(int[][] graph) {

        int expect = (1 << graph.length) - 1;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            q.offer(new int[]{i, 1 << i});
        }
        
        boolean[][] visited = new boolean[graph.length][1 << graph.length];

        int step = -1;

        while(!q.isEmpty()){

            int size = q.size();

            ++step;

            for(int i=0; i<size; i++){

                int[] pair = q.poll();

                int node = pair[0];

                int state = pair[1];
                
                if(state == expect){
                    return step;
                }

                if(visited[node][state]){
                    continue;
                }

                visited[node][state] = true;

                for(int next: graph[node]){
                    q.offer(new int[]{next, state | (1 << next)});
                }

            }

        }

        return -1;

    }

}
