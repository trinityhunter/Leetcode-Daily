class Solution {

    public int largestCombination(int[] arr) {

        int n = arr.length;
        
        int max = 0;

        for(int i=0; i<24; i++){

            int count = 0;

            for(int j=0; j<n; j++){

                count += arr[j] & 1;

                arr[j] >>= 1;

            }

            max = Math.max(count, max);

        }

        return max;

    }
    
}
