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
    
    public static int[][] updateMatrix(List<List<Integer>> grid) {
        
        int[][] arr = new int[grid.size()][grid.size()];
        
        boolean[][] vis = new boolean[grid.size()][grid.size()];
        
        Queue<Tuple> q = new ArrayDeque<>();
        
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid.size(); j++){
                if(grid.get(i).get(j) == 1){
                    
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
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int[][] distGrid = updateMatrix(grid);

        int n = grid.size();

        int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int res = 2 * n;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        pq.offer(new int[]{distGrid[0][0], 0, 0});

        distGrid[0][0] = -1;

        while(!pq.isEmpty()){

            int[] cur = pq.poll();

            int dist = cur[0], r = cur[1], c = cur[2];

            res = Math.min(res, dist);

            if(r == n - 1 && c == n - 1){
                break;
            }

            for(int[] d: direct){

                int row = r + d[0], col = c + d[1];

                if(row < 0 || col < 0 || row == n || col == n || distGrid[row][col] == -1){
                    continue;
                }

                pq.offer(new int[]{distGrid[row][col], row, col});

                distGrid[row][col] = -1;
                
            }

        }
        
        return res;
        
    }
    
}
