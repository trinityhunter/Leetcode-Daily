class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        if (n == 1)
            return adjacentPairs[0];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair: adjacentPairs) {
            int l = pair[0];
            int r = pair[1];
            
            List<Integer> lArr = map.getOrDefault(l, new ArrayList<>(2));
            lArr.add(r);
            map.put(l, lArr);
            
            List<Integer> rArr = map.getOrDefault(r, new ArrayList<>(2));
            rArr.add(l);
            map.put(r, rArr);
        }
        
        int[] ends = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() == 1)
                ends[idx++] = entry.getKey();
        }
        int[] result = new int[n + 1];
        result[0] = ends[0];
        result[n] = ends[1];
        for (int i = 1; i < n; i++) {
            int left = result[i - 1];
            List<Integer> adj = map.get(left);
            if (adj.size() == 1)
                result[i] = adj.get(0);
            else {
                int leftLeft = result[i - 2];
                for (int x: adj) {
                    if (x == left || x == leftLeft)
                        continue;
                    result[i] = x;
                }
            }
            
        }
        
        return result;
    }
}
