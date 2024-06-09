class Solution {

    public int subarraysDivByK(int[] A, int K) {

        int[] count = new int[K];

        count[0] = 1;

        int prefix = 0;
        
        int ans = 0;

        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            ans += count[prefix]++;
        }

        return ans;

    }

}
