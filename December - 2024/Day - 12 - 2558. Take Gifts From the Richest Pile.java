class Solution {

    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<gifts.length; i++){
            pq.add(gifts[i]);
        }

        long ans = 0;

        while(pq.size()>0 && k>0){
            int temp1 = pq.remove();
            int temp2 = (int)Math.floor(Math.sqrt(temp1));
            pq.add(temp2);
            k--;
        }

        while(pq.size()>0){
            ans += pq.remove();
        }

        return ans;

    }

}
