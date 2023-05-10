class Solution {

    public int[][] generateMatrix(int n) {
        
        int[][] arr = new int[n][n];

        int count = 1;

        int sr = 0;

        int sc = 0;

        int er = arr.length-1;

        int ec = arr[0].length-1;

        int tle = n*n;

        int dir = -1;

        while(tle>0){

            dir = (dir+1)%4;

            if(dir == 0){
                for(int j=sc; j<=ec; j++){
                    arr[sr][j] = count;
                    count++;
                    tle--;
                }
                sr++;
            }
            else if(dir == 1){
                for(int i=sr; i<=er; i++){
                    arr[i][ec] = count;
                    count++;
                    tle--;
                }
                ec--;
            }
            else if(dir == 2){
                for(int j=ec; j>=sc; j--){
                    arr[er][j] = count;
                    count++;
                    tle--;
                }
                er--;
            }
            else{
                for(int i=er; i>=sr; i--){
                    arr[i][sc] = count;
                    count++;
                    tle--;
                }
                sc++;
            }

        }

        return arr;

    }

}
