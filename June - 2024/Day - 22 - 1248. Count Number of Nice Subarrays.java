class Solution {

    public int numberOfSubarrays(int[] nums, int k) {

        int count = 0;

        int odd = 0;

        int i = 0;
        
        int j = 0;

        int ans = 0;

        while(j<nums.length){

            if(nums[j]%2 == 1){
                odd++;
                count = 0;
            }

            if(odd == k){
                while(odd == k){
                    if(nums[i]%2 == 1){
                        odd--;
                    }
                    count++;
                    i++;
                }
            }
            
            ans += count;

            j++;

        }

        return ans;

    }

}
