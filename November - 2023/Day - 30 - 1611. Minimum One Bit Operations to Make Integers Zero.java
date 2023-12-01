class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int size = countBits(n);
        int count = 0, bits = size;
        while (bits > 0) {
            if (getBit(size - 1, n) == 1) {
                count += (int) Math.pow(2, bits) - 1 -
                        minimumOneBitOperations(((1 << bits - 1) - 1) & n);
                return count;
            } else {
                n <<= 1;
                bits--;
            }
        }
        return count;
    }

    public int countBits(int number) {
        return (int) (Math.log(number) / Math.log(2) + 1);
    }

    public int getBit(int i, int num) {
        if ( i < 0) return 1;
        return (num & (1 << i)) == 0 ? 0 : 1;
    }
}
