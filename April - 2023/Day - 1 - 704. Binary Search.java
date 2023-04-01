class Solution {

    public static int helper(int[] nums, int low, int high, int target){

        if(low>high){
            return -1;
        }

        int mid = (low+high)/2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid]<target){
            return helper(nums, mid+1, high, target);
        }
        else{
            return helper(nums, low, mid-1, target);
        }

    }

    public int search(int[] nums, int target) {

        /////////// Iterative Approach - 

        // int low = 0;

        // int high = nums.length - 1;

        // while(low <= high){

        //     int mid = (low+high) / 2;

        //     if(nums[mid] == target){
        //         return mid;
        //     }
        //     else if(nums[mid] < target){
        //         low = mid + 1;
        //     }
        //     else{
        //         high = mid - 1;
        //     }

        // }

        // return -1;

        //////////////////////////////////////////////////////////////////////////////////////

        ///////////// Recursive Approach - 

        return helper(nums, 0, nums.length-1, target);

    }

}
