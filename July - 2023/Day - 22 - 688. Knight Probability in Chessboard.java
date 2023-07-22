class Solution {

    public static double helper(int n, int k, int sr, int sc){

        if(sr<0 || sr>=n || sc<0 || sc>=n){
            return 0.0;
        }

        if(k == 0){
            return 1.0;
        }

        sr = Math.min(sr, n-1-sr);

        sc = Math.min(sc, n-1-sc);

        if(sr < sc){
            return helper(n, k, sc, sr);
        }

        if(cache[sr][sc][k]!=null){
            return cache[sr][sc][k];
        }

        double ans = 0.0;

        for(int[] move: moves){
            ans += helper(n, k-1, sr+move[0], sc+move[1])/8.0;
        }

        return cache[sr][sc][k] = ans;

    }

    private static int[][] moves = {{2, 1}, {-2, 1}, {1, 2}, {-1, 2}, {2, -1}, {-2, -1}, {1, -2}, {-1, -2}};

    public static Double[][][] cache;

    public double knightProbability(int n, int k, int row, int column) {

        cache = new Double[(n/2)+1][(n/2)+1][k+1];

        double ans = helper(n, k, row, column);

        return ans;

    }
    
}
