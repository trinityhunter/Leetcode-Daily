class Solution {

    public int findMaxK(int[] nums) {
        
        int[] pos = new int[1001];

        int[] neg = new int[1001];
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                pos[nums[i]]++;
            }
            else{
                neg[Math.abs(nums[i])]++;
            }
        }
        
        int max = -1;
        
        for(int i=0; i<nums.length; i++){
            if(pos[Math.abs(nums[i])] >= 1 && neg[Math.abs(nums[i])] >= 1){
                max = Math.max(max, Math.abs(nums[i]));
            }
        }
        
        return max;
        
    }
    
}
