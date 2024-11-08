class Solution {

    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int total = nums[0];

        int[] res = new int[nums.length];

        for(int i=1; i<nums.length; i++){
            total = total ^ nums[i];
        }

        int max = (int)(Math.pow(2, maximumBit))-1;

        for(int i=0; i<nums.length; i++){
            res[i] = (~total ^ ~max);
            total = (~total ^ ~nums[nums.length-1-i]);
        }

        return res;

    }
    
}
