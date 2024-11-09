class Solution {

    public long minEnd(int n, int x) {
        
        long result = x;

        long goal = n - 1;

        long bitPosition = 0;

        while(goal > 0){

            if((result & (1L << bitPosition)) == 0){

                result |= (goal & 1) << bitPosition;

                goal >>= 1;

            }

            bitPosition++;

        }

        return result;

    }

}
