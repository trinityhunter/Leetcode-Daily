class Solution {

    public long maximumImportance(int n, int[][] roads) {
        
        int[] degree = new int[n];

        for(int[] road: roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        Integer[] cities = new Integer[n];

        for(int i=0; i<n; i++){
            cities[i] = i;
        }

        Arrays.sort(cities, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(degree[b], degree[a]);
            }
        });
        
        int[] cityValues = new int[n];

        for(int i=0; i<n; i++){
            cityValues[cities[i]] = n - i;
        }
        
        long totalImportance = 0;

        for(int[] road: roads){
            totalImportance += cityValues[road[0]] + cityValues[road[1]];
        }
        
        return totalImportance;

    }
    
}
