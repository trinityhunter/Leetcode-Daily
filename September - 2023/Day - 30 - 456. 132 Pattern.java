class Solution {

    public boolean find132pattern(int[] nums) {
        
        int[] min = new int[nums.length];
          
        int minEle = nums[0];

        for(int i=0; i<nums.length; i++){
            minEle = Math.min(minEle , nums[i]);
            min[i] = minEle;
        }
 
        Stack<Integer> st = new Stack();

        for(int i=nums.length-1; i>=0; i--){

            while(st.size()>0 && st.peek()<=min[i]){
                st.pop();
            }

            if(st.size()>0 && st.peek()>min[i] && st.peek()<nums[i]){
                return true;
            }
            
            st.push(nums[i]);

        }

        return false;

    }
    
}
