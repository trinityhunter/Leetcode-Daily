class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        long sum = 0;

        int i = 0;

        int j = 0;

        long max = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        while(j<nums.length){

            sum += nums[j];

            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

            if(j-i+1 == k){
                if(hm.size() == k){
                    max = Math.max(max, sum);
                }

                if(hm.get(nums[i]) == 1){
                    hm.remove(nums[i]);
                }
                else{
                    hm.put(nums[i], hm.getOrDefault(nums[i], 0) - 1);
                }

                sum -= nums[i];
                
                i++;
            }

            j++;

        }

        return max;

    }

}
