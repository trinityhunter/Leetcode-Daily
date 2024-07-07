class Solution {

    public int numWaterBottles(int filled, int rate) {

        int count = filled;

        int empty = filled;

        while(empty>=rate){
            count += empty/rate;
            empty = empty%rate + empty/rate;
        }

        return count;

    }

}
