class Solution {

    public int kInversePairs(int n, int k) {

        int mod = 1000000007;

        int[] pre = new int[k + 1];

        int[] cur = new int[k + 1];

        pre[0] = 1;

        for(int i=1; i<=n; i++){
            cur[0] = 1;
            long val = 0;

            for(int j=1; j<=k; j++){
                val = pre[j] + cur[j-1];
                if(j >= i){
                    val -= pre[j-i];
                }
                cur[j] = (int)((val + mod) % mod);
            }

            int[] temp = pre;
            pre = cur;
            cur = temp;
        }

        return pre[k];

    }
    
}
