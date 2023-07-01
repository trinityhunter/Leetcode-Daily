class Solution {
    
    public static int helper(int[] cookies, int[] arr, int ind, int k){
        
        if(ind<0){

            int max = 0;;

            for(int i=0; i<arr.length; i++){
                max = Math.max(max, arr[i]);
            }

            return max;

        }
        
        int curr = Integer.MAX_VALUE;

        for(int j=0; j<k; j++){

            arr[j] += cookies[ind];

            curr = Math.min(curr, helper(cookies, arr, ind-1, k));

            arr[j] -= cookies[ind];

        }
        
        return curr;
        
    }
    
    public int distributeCookies(int[] cookies, int k) {
        
        int[] arr = new int[k];
        
        int ans =  helper(cookies, arr, cookies.length-1, k);

        return ans;
        
    }

}
