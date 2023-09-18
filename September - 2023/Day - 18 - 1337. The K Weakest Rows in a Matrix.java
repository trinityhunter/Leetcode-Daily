class Solution {

    public static int minIndex(ArrayList<Integer> arr){

        int min = Integer.MAX_VALUE;

        int minIndex = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)<min){
                min = arr.get(i);
                minIndex = i;
            }
        }
        
        return minIndex;

    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            arr.add(count);
        }
        
        int [] ans = new int [k];
        
        for(int i=0; i<k; i++){
            ans[i] = minIndex(arr);
            arr.set(ans[i], Integer.MAX_VALUE);
        }
        
        return ans;

    }
    
}
