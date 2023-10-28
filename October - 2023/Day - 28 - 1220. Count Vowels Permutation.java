class Solution {

    public int countVowelPermutation(int n) {

        long[] tmp = {1, 1, 1, 1, 1};

        long mod = 1_000_000_007;

        for(int k=0; k<n-1; k++){

            tmp = new long[]{tmp[1], tmp[0]+tmp[2], tmp[0]+tmp[1]+tmp[3]+tmp[4], tmp[2]+tmp[4], tmp[0]};

            tmp = new long[]{tmp[0]%mod, tmp[1]%mod, tmp[2]%mod, tmp[3]%mod, tmp[4]%mod};

        }
        
        return (int)Arrays.stream(tmp).reduce(0, (x, y) -> (x + y) % mod);

    }

}
