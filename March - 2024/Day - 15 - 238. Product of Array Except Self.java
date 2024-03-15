class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefix = new int[nums.length];
        
        int[] suffix = new int[nums.length];
        
        int p = 1;
        
        for(int i=0; i<nums.length; i++){
            p *= nums[i];
            prefix[i] = p;
        }
        
        int s = 1;
        
        for(int i=nums.length-1; i>=0; i--){
            s *= nums[i];
            suffix[i] = s;
        }
        
        int[] arr = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            if(i == 0){
                arr[i] = suffix[i+1];
            }
            else if(i == nums.length-1){
                arr[i] = prefix[i-1];
            }
            else{
                arr[i] = prefix[i-1] * suffix[i+1];
            }
        }
        
        return arr;
        
    }
    
}
