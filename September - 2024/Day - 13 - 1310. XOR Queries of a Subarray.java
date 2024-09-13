class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {

        int ans[] = new int[queries.length];

        int xor = 0;

        for(int i=0; i<arr.length; i++){
            xor = xor ^ arr[i];
            arr[i] = xor;
        }

        for(int i=0; i<queries.length; i++){

            int x = queries[i][0];
            
            int y = queries[i][1];

            if(x>0){
                ans[i] = (arr[y]^arr[x-1]);
            }
            else{
                ans[i] = arr[y];
            }

        }

        return ans;

    }
    
}
