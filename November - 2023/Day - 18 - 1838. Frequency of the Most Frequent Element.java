class Solution {

    public int maxFrequency(int[] A, int k) {

        int max = 1;
        
        int i = 0;

        long sum = 0;

        Arrays.sort(A);

        for(int j=0; j<A.length; j++){

            sum += A[j];

            while(sum+k < (long)A[j]*(j-i+1)){
                sum -= A[i];
                i += 1;
            }

            max = Math.max(max, j - i + 1);

        }

        return max;

    }

}
