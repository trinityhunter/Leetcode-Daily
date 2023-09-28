class Solution {

    public int[] sortArrayByParity(int[] nums) {

        int [] arr = new int [nums.length];
        
        int frontIndex = 0;
        
        int backIndex = nums.length-1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                arr[frontIndex] = nums[i];
                frontIndex++;
            }
            else{
                arr[backIndex] = nums[i];
                backIndex--;
            }
        }

        return arr;
        
    }

}
