class Solution {

    int[] dirs = {1, 0, -1, 0, 1, -1, -1, 1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0]==1){
            return -1;
        }

        if(grid.length==1){
            return 1;
        }
       
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});

        grid[0][0] = 1;

        int path = 0,len = grid.length;

        while(queue.size() > 0){
            int cnt = queue.size();
            path++;

            while(cnt-- > 0){
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                for(int i = 0; i < 8; i++){
                    int x0 = x+dirs[i], y0 = y+dirs[i+1];
                    
                    if(x0<0||x0>=len||y0<0||y0>=len||grid[x0][y0]==1){
                        continue;
                    }
                    if(x0==len-1&&y0==len-1){
                        return path + 1;
                    }

                    grid[x0][y0] = 1;
                    queue.add(new int[]{x0,y0});
                }
            }
        }
        
        return -1;

    }

}
