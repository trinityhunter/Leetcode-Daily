class Solution {

    public static boolean valid(int mid, int[] nums){

        long sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > (long)mid * (i+1)){
                return false;
            }
        }

        return true;

    }

    public static int minimizeArrayValue(int[] nums) {

        int left = 0;
        
        int right = Arrays.stream(nums).max().getAsInt();
        
        int best = 0;
        while(left <= right){

            int mid = (left + (right-left)/2);

            if(valid(mid, nums)){
                best = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return best;

    }

}
