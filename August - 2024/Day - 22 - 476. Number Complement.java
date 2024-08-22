 class Solution {

    public int findComplement(int num) {
        
        int bitLength = Integer.toBinaryString(num).length();
        
        int mask = (1 << bitLength) - 1;
        
        return mask - num;

    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.findComplement(5));

        System.out.println(sol.findComplement(1));

    }
    
}
