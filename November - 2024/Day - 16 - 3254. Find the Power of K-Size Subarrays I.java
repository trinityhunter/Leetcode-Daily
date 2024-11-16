class Solution {

    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n-k+1];

        for(int i=0; i<ans.length; i++){
            ans[i] = -1;
        }

        int i = 0, j = 0;

        while(j<n){

            if(j>0 && nums[j] - nums[j-1]!=1){
                i = j;
            }
            
            while(i<j && j-i+1>k){
                i++;
            }
            
            if(j-i+1 == k){
                ans[j-k+1] = nums[j];
            }

            j++;

        }

        return ans;

    }
    
}
