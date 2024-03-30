class Solution {

    public static int helper(int[] nums, int k){

        int i = 0;

        int j = 0;

        int ans = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        while(j<nums.length){

            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

            while(hm.size()>k){
                if(hm.get(nums[i]) == 1){
                    hm.remove(nums[i]);
                }
                else{
                    hm.put(nums[i], hm.getOrDefault(nums[i], 0) - 1);
                }
                i++;
            }

            ans += j-i+1;

            j++;

        }

        return ans;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return helper(nums, k) - helper(nums, k-1);

    }

}
