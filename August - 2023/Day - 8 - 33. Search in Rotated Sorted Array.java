class Solution {

    public static int helper(int[] nums, int low, int high, int target, int pivot){

        if(low>high){
            return -1;
        }

        int mid = (low + high)/2;

        int newMid = (mid + pivot)%nums.length;

        if(nums[newMid] == target){
            return newMid;
        }
        
        if(nums[newMid]<target){
            return helper(nums, mid+1, high, target, pivot);
        }
        else{
            return helper(nums, low, mid-1, target, pivot);
        }

    }

    public int search(int[] nums, int target) {
        
        int low = 0;
        
        int high = nums.length-1;

        while(low < high){

            int mid = (low+high)/2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            } 

        }
        
        int pivot = low;

        return helper(nums, 0, nums.length-1, target, pivot);

    }

}
