class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize!=0){
            return false;
        }

        if(groupSize == 1){
            return true;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<hand.length; i++){
            pq.add(hand[i]);
        }

        while(pq.size()>0){

            int rem = pq.remove();

            rem += 1;

            for(int i=0; i<groupSize-1; i++){
                if(pq.contains(rem)){
                    pq.remove(rem);
                    rem += 1;
                }
                else{
                    return false;
                }
            }

        }

        return true;

    }

}
