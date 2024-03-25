class Solution {

    public static int max(int [] nums){

        int max = 0;
        
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        return max;

    }
    
    public List<Integer> findDuplicates(int[] nums) {

        int [] arr = new int [max(nums)+1];
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]++;
            if(arr[nums[i]]==2){
                ans.add(nums[i]);
            }
        }
        
        return ans;

    }
    
}
