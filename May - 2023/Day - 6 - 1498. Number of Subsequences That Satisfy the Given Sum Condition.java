class Solution {

    public int numSubseq(int[] nums, int target) {

        int mod = 1000000007;

        Arrays.sort(nums);

        int[] arr = new int[nums.length + 1];

        arr[0] = 1;

        for(int i=1; i<=nums.length; i++){
            arr[i] = (arr[i-1] * 2) % mod;
        }

        int l = 0; 

        int r = nums.length-1; 

        int ans = 0;

        while(l <= r){

            if(nums[l] + nums[r] <= target){
                ans = (ans + arr[r-l]) % mod;
                l += 1;
            }
            else{
                r -= 1;
            }

        }
       
        return ans;

    }

}
