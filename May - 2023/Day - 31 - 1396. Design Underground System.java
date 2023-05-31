class UndergroundSystem {
    
    HashMap<Integer, Pair<String, Integer>> hm1 = new HashMap<>();
    
    HashMap<String, HashMap<String, int[]>> hm2 = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t){

        hm1.put(id, new Pair(stationName, t));

    }
    
    public void checkOut(int id, String end, int t) {
        
        Pair<String, Integer> start = hm1.get(id);
        
        hm2.putIfAbsent(start.getKey(), new HashMap<>());
        
        hm2.get(start.getKey()).putIfAbsent(end, new int[2]);
        
        hm2.get(start.getKey()).get(end)[0]++;
        
        hm2.get(start.getKey()).get(end)[1] += (t - start.getValue());
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        HashMap<String, int[]> hm = hm2.get(startStation);
        
        int[] arr = hm.get(endStation);
        
        return (double)arr[1]/arr[0];

    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
