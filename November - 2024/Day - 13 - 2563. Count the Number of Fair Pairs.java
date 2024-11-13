class Solution {

    public static long helper(int[] nums, int req){

        long ans = 0;

        int i = 0;

        for(int j = nums.length-1; i<j; i++){
            while(i<j && nums[i] + nums[j] > req){
                j--;
            }
            ans += j-i;
            System.out.println(ans + " " + j + " " + i);
        }

        return ans;

    }

    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);

        long ans = helper(nums, upper) - helper(nums, lower-1); 

        return ans;

    }


}
