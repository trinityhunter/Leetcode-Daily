class Solution {

    public int singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(int key: hm.keySet()){
            if(hm.get(key) == 1){
                return key;
            }
        }

        return 0;

        // int ones = 0;
        // int twos = 0;
        
        // for(int i: nums){
        //     ones = (ones ^ i) & (~twos);
        //     twos = (twos ^ i) & (~ones);
        // }
        
        // return ones;

    }

}
