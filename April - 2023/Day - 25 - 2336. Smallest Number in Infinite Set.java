class SmallestInfiniteSet {

    public PriorityQueue<Integer> pq;

    public int index;

    public SmallestInfiniteSet() {

        pq = new PriorityQueue<Integer>();
        index = 1;

    }
    
    public int popSmallest() {

        if(pq.size()>0){
            return pq.poll();
        }

        return index++;

    }
    
    private boolean is_in_pq(int num){

        for(int i : pq){
            if (i == num){
                return true;
            }
        }

        return false;

    }
    
    public void addBack(int num) {

        if( num < index && !is_in_pq(num)){
            pq.add(num);
        }
        
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
