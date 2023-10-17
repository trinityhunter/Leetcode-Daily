class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        boolean[] visited = new boolean[n];

        for(int i: leftChild){
            if(i != -1){
                visited[i] = true;
            }
        }

        for(int i: rightChild){
            if(i != -1){
                visited[i] = true;
            }
        }

        int count = 0;

        int root = -1;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                root = i;
                count++;
            }
        }

        if(count!=1){
            return false;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(root);

        Arrays.fill(visited, false);

        visited[root] = true;

        while(!q.isEmpty()){

            int node = q.poll();

            if(leftChild[node] != -1){
                if(visited[leftChild[node]]){
                    return false;
                }
                q.add(leftChild[node]);
                visited[leftChild[node]] = true;
            }

            if(rightChild[node] != -1){
                if(visited[rightChild[node]]){
                    return false;
                }
                q.add(rightChild[node]);
                visited[rightChild[node]] = true;
            }

        }

        boolean check = true;
        
        for(boolean visit: visited){
            check = check && visit;
        }

        return check;

    }
    
}
