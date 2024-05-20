class Solution {

    public int subsetXORSum(int[] ar) {

        int n = ar.length, sum = 0;

        int total = 1 << n;

        for(int mask=0; mask<total; mask++){
            int xor = 0;
            for(int j=0; j<20; j++){
                if((mask & (1 << j)) > 0){
                    xor ^= ar[j];
                }
            }
            sum += xor;
        }
        
        return sum;

    }
    
}
