class Solution {

    public static boolean underRadius(int[] mat, int x, int y, int r){
        
        long r1 = r;
        
        long x1 = x;
        
        long y1 = y;
        
        long x2 = mat[0];
        
        long y2 = mat[1];
        
        long dist = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);

        long rad = r1*r1;
        
        return dist <= rad;

    }

    public static void helper(int[][] arr, int[] blasted, int w){

        for(int i=0; i<arr.length; i++){
            if(blasted[i] == 0 && underRadius(arr[i], arr[w][0], arr[w][1], arr[w][2])){
                blasted[i] = 1;
                helper(arr,blasted,i);
            }
        }

    }

    public static int getBombs(int[][] arr, int ind){

        int[] barr = new int[arr.length];

        int x = arr[ind][0];
        
        int y = arr[ind][1];
        
        int r = arr[ind][2];

        int count = 0;

        barr[ind] = 1;

        helper(arr, barr, ind);
        
        for(int n: barr){
            if(n == 1){
                count++;
            }
        }
            
        return count;

    }

    public int maximumDetonation(int[][] bombs) {

        int max = 0;
        
        for(int i=0; i<bombs.length; i++){

            int num = getBombs(bombs, i);

            max = Math.max(max, num);

        }
        
        return max;

    }
    
}
