class Solution {

    public boolean canSortArray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = Arrays.copyOf(nums, nums.length);

        for(int num: nums){

            int count = 0;
            
            int t = num;

            while(num>0){
                count = num %2 != 0 ? count + 1 : count;

                num /= 2;

            }

            map.put(t, count);

        }

        for(int i=0; i<nums.length-1; i++){

            if(nums[i]>nums[i+1] && map.get(nums[i])==map.get(nums[i+1])){

                int temp = nums[i];

                nums[i] = nums[i+1];

                nums[i+1] = temp;

                i =- 1;

            }

        }

        Arrays.sort(arr);

        return Arrays.equals(arr, nums);

    }
    
}
