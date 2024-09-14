class Solution {

    public int longestSubarray(int[] nums) {

        int max = 0;
        
        int count = 0;
        
        int ans = 0;

        for(int i: nums){

            if(i == max){
                count++;
            }
            else if(i > max){
                count = ans = 1;
                max =i ;
            }
            else{
                count = 0;
            }

            ans = Math.max(count, ans);

        }

        return ans;

    }
    
}
