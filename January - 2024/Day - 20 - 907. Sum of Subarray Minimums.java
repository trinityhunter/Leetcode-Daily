class Solution {

    public static int helper(int[] arr, int start){

        int minVal = arr[start];

        int result = 0;

        for(int i=start; i<arr.length; i++){
            minVal = Math.min(minVal, arr[i]);
            result += minVal;
        }

        return result;
        
    }

    public static int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {

        long sum = 0;

        for(int i=0; i<arr.length; i++){
            sum = (sum + helper(arr, i)) % MOD;
        }

        return (int)sum;

    }

}
