class Solution {

    public int numWays(int steps, int arrLen) {

        int mod = 1_000_000_007;

        arrLen = Math.min(steps,arrLen);

        long[] prev = new long[arrLen+2];

        long[] curr = new long[arrLen+2];

        Arrays.fill(prev,0);

        Arrays.fill(curr,0);

        prev[arrLen] = 1;

        for(int j=1; j<steps+1; j++){
            for(int i=1; i<arrLen+1; i++){
                curr[i] = (prev[i-1] + prev[i] + prev[i+1]) % mod;
            }
            long[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        
        return (int)prev[arrLen];

    }

}
