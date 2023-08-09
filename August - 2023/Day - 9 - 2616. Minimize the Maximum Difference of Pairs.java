class Solution {

    public static boolean helper(int[] nums, int p, int m){

        int count = 0;

        for(int i=1; i<nums.length; i++){

            if(nums[i] - nums[i-1] <= m){
                count++;
                i++;
            }

        }

        if(count >= p){
            return true;
        }

        return false;
        
    }

    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);

        int left = 0;

        int right = nums[nums.length - 1] - nums[0];

        int mid = 0;

        while(left<right){

            mid = (left+right)/2;

            if(helper(nums, p, mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }

        }

        return left;

    }

}
