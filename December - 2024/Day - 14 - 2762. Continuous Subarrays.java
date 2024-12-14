class Solution {
    
    public static long helper(int[] nums){
        
        int i = 0;
        
        long res = 0;
        
        int j = 0;
        
        ArrayDeque<Integer> max = new ArrayDeque<>();
        
        ArrayDeque<Integer> min = new ArrayDeque<>();

        while(j < nums.length){
            
            while(max.size()>0 && nums[max.peekLast()] < nums[j]){
                max.removeLast();
            }
            max.addLast(j);
            
            
            while (min.size()>0 && nums[min.peekLast()] > nums[j]) {
                min.removeLast();
            }
            min.addLast(j);
            
            while(Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > 2){
                int maxi = max.peekFirst();
                int mini = min.peekFirst();
                if(maxi<mini){
                    i = max.removeFirst() + 1;
                } 
                else{
                    i = min.removeFirst() + 1;
                }
            }

            res += j-i+1;
            
            j++;
            
        }
        
        return res;
        
    }
    
    public long continuousSubarrays(int[] nums) {
        
        long ans = helper(nums);
        
        return ans;
        
    }
    
}
