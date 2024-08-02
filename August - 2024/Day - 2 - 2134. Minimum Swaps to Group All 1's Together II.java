class Solution {

    public int minSwaps(int[] nums) {

        int oneCount = 0;

        int n = nums.length;

        for(int num : nums){
            if(num == 1){
                oneCount++;
            }
        }

        if(oneCount <= 1){
            return 0;
        }

        int minSwaps = Integer.MAX_VALUE;

        int windowSum = 0;

        for(int i=0; i<oneCount; i++){
            windowSum += nums[i];
        }

        minSwaps = oneCount - windowSum;

        for(int i=1; i<=n; i++){

            windowSum -= nums[i - 1];

            windowSum += nums[(i + oneCount - 1) % n];

            int swapsNeeded = oneCount - windowSum;

            minSwaps = Math.min(minSwaps, swapsNeeded);

        }
        
        return minSwaps;

    }
    
}
