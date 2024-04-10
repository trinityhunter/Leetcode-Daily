class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        int n = deck.length;

        int[] res = new int[n];

        Deque<Integer> deq = new LinkedList<>();

        for(int i=0; i<n; i++){
            deq.add(i);
        }

        for(int card: deck){
            int idx = deq.poll();
            res[idx] = card;
            if(!deq.isEmpty()){
                deq.add(deq.poll());
            }
        }

        return res;

    }
    
}
