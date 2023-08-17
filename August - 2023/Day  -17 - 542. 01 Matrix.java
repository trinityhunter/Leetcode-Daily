class Tuple{

    int sr;

    int sc;

    int dist;

    public Tuple(int sr, int sc, int dist){

        this.sr = sr;

        this.sc = sc;

        this.dist = dist;

    }

}

class Solution {

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Tuple> q = new ArrayDeque<>();

        int[][] arr = new int[mat.length][mat[0].length];

        boolean[][] vis = new boolean[mat.length][mat[0].length];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new Tuple(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while(q.size()>0){

            int count = q.size();

            for(int i=0; i<count; i++){
                
                Tuple rem = q.remove();
                
                int sr = rem.sr;
                
                int sc = rem.sc;
                
                arr[sr][sc] = rem.dist;
                
                if(sc+1<arr[0].length && vis[sr][sc+1] == false){
                    q.add(new Tuple(sr, sc+1, rem.dist+1));
                    vis[sr][sc+1] = true;
                }
                
                if(sr+1<arr.length && vis[sr+1][sc] == false){
                    q.add(new Tuple(sr+1, sc, rem.dist+1));
                    vis[sr+1][sc] = true;
                }
                
                if(sc-1>=0 && vis[sr][sc-1] == false){
                    q.add(new Tuple(sr, sc-1, rem.dist+1));
                    vis[sr][sc-1] = true;
                }
                
                if(sr-1>=0 && vis[sr-1][sc] == false){
                    q.add(new Tuple(sr-1, sc, rem.dist+1));
                    vis[sr-1][sc] = true;
                }

            }

        }

        return arr;
        
    }

}
