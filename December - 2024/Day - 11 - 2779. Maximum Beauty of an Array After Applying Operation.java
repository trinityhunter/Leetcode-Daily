class Solution {

    public int maximumBeauty(int[] nums, int k) {

        Arrays.sort(nums);

        int[] start = new int[nums.length];

        int[] end = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            start[i] = nums[i] - k;
            end[i] = nums[i] + k;
        }

        int i = 0;
        
        int j = 0;
        
        int ans = 0;

        while(j<nums.length){

            while(i<nums.length && start[i]<=end[j]){
                i++;
            }

            ans = Math.max(ans, i-j);

            j++;

        }
        
        return ans;

    }

}
