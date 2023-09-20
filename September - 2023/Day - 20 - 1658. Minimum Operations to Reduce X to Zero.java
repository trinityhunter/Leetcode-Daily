class Solution {

    public int minOperations(int[] nums, int x) {

        int target = Arrays.stream(nums).sum() - x;

        if(target<0){
            return -1;
        }

        if(target == 0){
            return nums.length;
        }

        int count = -1;

        int sum = 0;

        int i = 0;

        int j = 0;

        while(j<nums.length){

            sum += nums[j];

            while(sum>target){
                sum -= nums[i];
                i++;
            }

            if(sum == target){
                count = Math.max(count, j - i + 1);
            }

            j++;

        }

        if(count == -1){
            return -1;
        }

        return nums.length - count;

    }

}
