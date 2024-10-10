class Solution {

    public int maxWidthRamp(int[] nums) {

        Stack<Integer> s = new Stack<>();

        int n = nums.length;

        for(int i=0; i<n; i++){
            if(s.isEmpty() || nums[s.peek()] > nums[i]){
                s.push(i);
            }
        }

        int maxWidth = 0;

        for(int j=n-1; j>=0; j--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[j]){
                maxWidth = Math.max(maxWidth, j - s.pop());
            }
        }

        return maxWidth;

    }
    
}
