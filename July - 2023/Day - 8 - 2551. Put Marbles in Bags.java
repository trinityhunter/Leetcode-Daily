class Solution {

    public long putMarbles(int[] weights, int k) {

        if(k == 1){
            return 0;
        }

        long[] arr = new long[weights.length - 1];

        long ans = 0;

        for(int i=0; i<weights.length-1; i++){
            arr[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(arr);

        for(int i=0; i<k-1; i++){
            ans += arr[weights.length-2-i] - arr[i];
        }

        return ans;

    }

}
