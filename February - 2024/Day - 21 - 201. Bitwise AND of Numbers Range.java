class Solution {

    public int rangeBitwiseAnd(int left, int right) {

        int basemask = left & right;

        while(right != 0 && right > left){
            right = right & (right - 1);
        }

        return right;

    }
    
}
