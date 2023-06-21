class Solution {

    public static long helper(int[] arr, int[] cost, int mid){
        
        long sum = 0;
            
        for(int i=0; i<arr.length; i++){
            sum += 1l * Math.abs(mid - arr[i]) * cost[i];
        }

        return sum;

    }

    public long minCost(int[] nums, int[] cost) {

        int left = 0;
        
        int right = 1000000;

        while(left <= right){

            int mid = (left + right)/2;

            long leftPart = helper(nums, cost, mid-1);

            long centrePart = helper(nums, cost, mid);

            long rightPart = helper(nums, cost, mid+1);

            if(leftPart >= centrePart && rightPart >= centrePart){
                return centrePart;
            }
            else if(leftPart < centrePart){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }
        
        return 0;

    }

}
