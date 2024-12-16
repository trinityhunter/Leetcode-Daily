//class Solution {
    //public int[] getFinalState(int[] nums, int k, int multiplier) {
        
    //}
//}

class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
                while (k-- > 0) {
                            int num = nums[0];
                                        int index = 0;

                                                   
                                                               for (int i = 1; i < nums.length; i++) {
                                                                               if (nums[i] < num) {
                                                                                                   num = nums[i];
                                                                                                                       index = i;
                                                                                                                                       }
                                                                                                                                                   }

                                                                                                                                                               
                                                                                                                                                                           nums[index] = nums[index] * multiplier;
                                                                                                                                                                                   }
                                                                                                                                                                                           return nums;
                                                                                                                                                                                               }
                                                                                                                                                                                               }
