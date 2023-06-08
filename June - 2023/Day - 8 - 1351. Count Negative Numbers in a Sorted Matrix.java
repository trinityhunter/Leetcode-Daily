class Solution {

    public static int helper(int[] arr){
        
        int left = 0;
        
        int right = arr.length;

        while(left < right){

            int m = (left + right)/2;

            if(arr[m] < 0){
                right = m;
            }
            else{
                left = m + 1;
            }

        }

        return arr.length - left;

    }

    public int countNegatives(int[][] grid) {

        int ans = 0;

        for(int i=0; i<grid.length; i++){
            ans += helper(grid[i]);
        }

        return ans;

    }

}
