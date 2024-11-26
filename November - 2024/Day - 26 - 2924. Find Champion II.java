class Solution {

    public int findChampion(int n, int[][] edges) {

        // HashSet<Integer> hs = new HashSet<>();

        // for(int[] a: edges){
        //     hs.add(a[1]);
        // }

        // if(n-hs.size()!=1){
        //     return -1;
        // }

        // for(int i=0 ; i<n ; i++){
        //     if(!hs.contains(i)){
        //         return i;
        //     }
        // }

        // return -1;

        // Indegree Edge Method

        int[] indegree = new int[n];

        for (int[] edge: edges) {
            indegree[edge[1]]++;
        }

        int count = 0;

        int ind = -1;

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                count++;
                ind = i;
            }
        }

        if(count == 1){
            return ind;
        }
        
        return -1;

    }

}
