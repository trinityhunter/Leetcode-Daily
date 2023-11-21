class Solution {

    public static int helper(int i){

        int tempI = i;

        int base = 1;

        while(tempI >= 10){
            tempI /= 10;
            base *= 10;
        }

        int res = 0;

        while(i >= 1){
            res += i % 10 * base;
            i /= 10;
            base /= 10;
        }

        return res;

    }
    
    public static int mod = 1000000007;

    public int countNicePairs(int[] nums) {

        HashMap<Integer, Long> map = new HashMap<>();

        for(int i: nums){
            map.compute(i - helper(i), (k, v) -> (v == null) ? 1 : v + 1);
        }

        long res = 0;

        for(Map.Entry<Integer, Long> entry: map.entrySet()){
            long n = entry.getValue();
            res += (n - 1) * n / 2;
        }

        return (int)(res % mod);

    }

}
