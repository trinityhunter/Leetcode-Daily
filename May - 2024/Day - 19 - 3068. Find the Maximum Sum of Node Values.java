class Solution {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        
        int n = nums.length;

        Integer [] diff = new Integer[n];

        long sum = 0;

        for(int i=0; i<n; i++){

            diff[i] = (nums[i]^k) - nums[i];

            sum += nums[i];
            
        }
        
        Arrays.sort(diff, Collections.reverseOrder());
        
        for(int i = 0; i<n; i+=2){

            if(i+1 == n){
                return sum;
            }

            int pair = diff[i] + diff[i+1];

            if(pair>0){
                sum+=pair;
            }

        }

        return sum;

    }

}
