class Solution {

    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;

        int left = 0, right = nums[n - 1] - nums[0];

        while(left < right){

            int mid = left + (right - left) / 2;

            int count = 0, j = 0;


            for(int i=0; i<n; i++){
                while(j < n && nums[j] - nums[i] <= mid){
                    j++;
                }
                count += j - i - 1;
            }

            if(count < k){
                left = mid + 1;
            }
            else{
                right = mid;
            }

        }

        return left;

    }
    
}
