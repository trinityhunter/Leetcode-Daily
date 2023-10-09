class Solution {

    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0){
            return new int[]{-1, -1};
        }

        int[] ans = new int[2];
        
        int low = 0;

        int high = nums.length-1;

        while(low<high){

            int mid = (low + high)/2;

            if(nums[mid]<target){
                low = mid + 1;
            }
            else{
                high = mid;
            }

        }

        if(nums[low] != target){
            return new int[]{-1, -1};
        }
        else{
            ans[0] = low;
        }

        high = nums.length-1;

        while(low<high){

            int mid = (low + high)/2 + 1;

            if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid;
            }

        }

        ans[1] = high;

        return ans;

    }

}
