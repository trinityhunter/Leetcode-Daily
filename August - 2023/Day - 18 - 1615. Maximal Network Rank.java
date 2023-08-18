class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {

        HashMap<Integer, Set<Integer>> hm = new HashMap<Integer, Set<Integer>>();    
        
        for(int i=0; i<n; i++){
            hm.put(i, new HashSet<>());
        }
        
        for(int i=0; i<roads.length; i++){
            hm.get(roads[i][0]).add(roads[i][1]);
            hm.get(roads[i][1]).add(roads[i][0]);
        }
        
        int max = 0;

        for(int i=0; i<n-1; i++){

            for(int j=i+1; j<n; j++){

                int maxi = hm.get(i).size();

                maxi += hm.get(j).size();

                if(hm.get(i).contains(j)){
                    maxi--;
                }
                
                max = Math.max(max, maxi);

            }

        }
        
        return max;

    }

}
