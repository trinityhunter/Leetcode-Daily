class SnapshotArray {

    public List<Map<Integer, Integer>> arr;
    
    public Map<Integer, Integer> hm;
    
    public SnapshotArray(int length) {

        arr  = new ArrayList<>(length);

        hm  = new HashMap<>(length);

    }
    
    public void set(int index, int val) {
        hm.put(index, val);
    }
    
    public int snap() {

        arr.add(hm);

        hm = new HashMap<>();

        return arr.size() - 1;

    }
    
    public int get(int index, int snap_id) {

        for (int i=snap_id; i>=0; i--){
            if(arr.get(i).containsKey(index)){
                return arr.get(i).get(index); 
            }
        }

        return 0;

    }

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
