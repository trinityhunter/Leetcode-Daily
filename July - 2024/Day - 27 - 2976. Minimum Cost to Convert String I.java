class Solution {

    final static int INF = Integer.MAX_VALUE;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] adj = new int[26][26];

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j) continue;

                adj[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<original.length;i++){
            int a = original[i]-'a';
            int b = changed[i]-'a';

            adj[a][b] = Math.min(adj[a][b], cost[i]);
        }

        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    if(adj[i][k] != INF && adj[k][j] != INF && adj[i][k] + adj[k][j] < adj[i][j]){
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        long minCost = 0;

        for(int i=0; i<source.length(); i++){
            int a = source.charAt(i)-'a';
            int b = target.charAt(i)-'a';

            if(adj[a][b]==INF) return -1;

            minCost += adj[a][b];
        }

        return minCost;
        
    }
    
}
