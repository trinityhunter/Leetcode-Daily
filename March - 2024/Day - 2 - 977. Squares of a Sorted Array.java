class Solution {

    public int[] sortedSquares(int[] nums) {
        
        int[] arr = new int[nums.length];
        
        int i = 0;

        int j = nums.length-1;
        
        for(int ind=nums.length-1; ind>=0; ind--){
            if(Math.abs(nums[i])<Math.abs(nums[j])){
                arr[ind] = nums[j] * nums[j];
                j--;
            }
            else{
                arr[ind] = nums[i] * nums[i];
                i++;
            }
        }
        
        return arr;
        
    }
    
}
