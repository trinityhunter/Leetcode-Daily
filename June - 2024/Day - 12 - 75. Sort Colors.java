class Solution {

    public void sortColors(int[] nums) {

        // Two Pass - 
        
        // int zero = 0;
        
        // int one = 0;
        
        // int two = 0;
        
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]==0){
        //         zero++;
        //     }
        //     else if(nums[i]==1){
        //         one++;
        //     }
        //     else if(nums[i]==2){
        //         two++;
        //     }
        // }
        
        // int index = 0;

        // for(int i=0; i<zero; i++){
        //     nums[index] = 0;
        //     index++;
        // }
        
        // for(int i=0; i<one; i++){
        //     nums[index] = 1;
        //     index++;
        // }
        
        // for(int i=0; i<two; i++){
        //     nums[index] = 2;
        //     index++;
        // }

        // One Pass - 

        int low = 0;
        
        int high = nums.length - 1;
        
        int index = 0;

        while(index <= high){
            if(nums[index] == 0){
                nums[index] = nums[low];
                nums[low] = 0;
                low++;
            }
            if(nums[index] == 2){
                nums[index] = nums[high];
                nums[high] = 2;
                high--;
                index--;
            }
            index++;
        }
        
    }

}
