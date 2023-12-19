class Solution {

    public int[][] imageSmoother(int[][] img) {

       int m = img.length;

       int n = img[0].length;

       int dir[][] = {{-1,0},{0,-1},{1,0},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

       int ans[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum = img[i][j];
                int count = 1;
                for(int d=0; d<dir.length; d++){
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    if(r>=0 && c>=0 && r<m && c<n){
                        count++;
                        sum+=img[r][c];
                    }
                }
                ans[i][j] = sum/count;
            }
        }

        return ans;

    }
    
}
