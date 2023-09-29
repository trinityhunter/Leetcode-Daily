class Solution {

    public boolean isMonotonic(int[] nums) {

        int n = nums.length;

        if(n<3){
            return true;
        }
        
        boolean increasing = false;
        
        boolean decreasing = false;

        for(int i=1; i<nums.length; i++){

            if(nums[i] == nums[i-1]){
                continue;
            }

            if(nums[i]>nums[i-1]){
                increasing = true;
            }
            else{
                decreasing = true;
            }

            if(increasing & decreasing){
                return false;
            }

        }

        return (increasing & decreasing) ? false: true;

    }

}
