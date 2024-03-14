class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int i = 0;

        int j = 0;

        int count = 0;

        int sum = 0;

        while(j<nums.length){

            sum += nums[j];

            while(i<j && sum>goal){
                sum -= nums[i];
                i++;
            }

            if(sum == goal){
                count++;
            }
            
            for(int left = i; sum == goal && nums[left] == 0 && left<j; left++){
                count++;
            }

            j++;

        }

        return count;

    }

}
