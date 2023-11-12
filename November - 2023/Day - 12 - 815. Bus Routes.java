class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        int n = routes.length;

        HashMap<Integer, ArrayList<Integer>> BusToBus = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int r:routes[i]) {
                BusToBus.putIfAbsent(r, new ArrayList<>());
                BusToBus.get(r).add(i);
            }
        }

        LinkedList<Integer> pq = new LinkedList<>();

        HashSet<Integer> busStand = new HashSet<>();

        boolean[] bus = new boolean[n];

        pq.addLast(source);

        busStand.add(source);

        int level = 0;

        while(pq.size() != 0) {
            int size = pq.size();
            while(size --> 0) {
                int remStand = pq.removeFirst();
                if(remStand == target) {
                    return level;
                }
                for (int rb: BusToBus.get(remStand)) {
                    if(bus[rb]) continue;
                    for(int s:routes[rb]) {
                        if(!busStand.contains(s)) {
                            pq.addLast(s);
                            busStand.add(s);
                        }
                    }
                    bus[rb] = true;
                }
            }
            level++;
        }

        return -1;

    }
    
}
