class Solution {

    public int minimumSize(int[] nums, int maxOperations) {

        int low = 1;
        
        int high = Arrays.stream(nums).max().getAsInt();

        while(low<high){

            int opts = 0;
            
            int mid = (low+high) >> 1;

            for(int num: nums){
                opts += (num-1)/mid;
            }

            // System.out.println("i: " + i + ", opts: "+ opts);

            if(opts > maxOperations){
                low = mid + 1;
            }
            else{
                high = mid;
            }

        } 

        return high;

    }
    
}
