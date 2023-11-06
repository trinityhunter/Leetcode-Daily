class SeatManager {

    PriorityQueue<Pair<Integer,Integer>> pq ;

    public SeatManager(int n) {
        
        pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        
        while(n>0){
            pq.add(new Pair(n,n));
            n--;
        }

    }
    
    public int reserve() {

        Pair rem = pq.poll();
        return (int)rem.getValue();

    }
    
    public void unreserve(int seatNumber) {

        pq.add(new Pair(seatNumber,seatNumber));

    }

}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
