class Solution {

    public long minimumReplacement(int[] nums) {

        long count = 0;
        
        for(int i=nums.length-1; i>=1; i--){

            if(nums[i-1]>nums[i]){

                int parts = nums[i-1]/nums[i];

                if(nums[i-1]%nums[i]!=0){
                   parts++;
                }

                count += parts-1;
                nums[i-1] = nums[i-1]/parts;
            }

        }

        return count;

    }

}
