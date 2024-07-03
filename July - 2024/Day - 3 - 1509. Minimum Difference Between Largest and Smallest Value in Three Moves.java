class Solution {

    public int minDifference(int[] nums) {

        if(nums.length < 5){
            return 0;
        }

        Arrays.sort(nums);

        int p1 = nums[nums.length - 1] - nums[3];

        int p2 = nums[nums.length - 1 - 1] - nums[2];

        int p3 = nums[nums.length - 1 - 2] - nums[1];

        int p4 = nums[nums.length - 1 - 3] - nums[0];
        
        return Math.min(Math.min(Math.min(p1, p2), p3), p4);
    
    }

}
