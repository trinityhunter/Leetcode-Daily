class Solution {

    public int removeStones(int[][] stones) {

        int n = stones.length;

        HashSet<String>vis=new HashSet<>();

        HashMap<Integer,ArrayList<Integer>>row=new HashMap<>();

        HashMap<Integer,ArrayList<Integer>>col=new HashMap<>();
        
        for(int i=0; i<n; i++){

            int x = stones[i][0];

            int y = stones[i][1];

            row.putIfAbsent(x, new ArrayList<>());
            col.putIfAbsent(y, new ArrayList<>());

            row.get(x).add(y);
            col.get(y).add(x);

        }

        int count = 0;

        for(int i=0; i<n; i++){

            int x = stones[i][0];

            int y = stones[i][1];

            String key = x + "," + y;

            if(!vis.contains(key)){
                count++;
                dfs(x,y,vis,row,col);
            }

        }

        return n-count;

    }

    void dfs(int x,int y,HashSet<String>vis,HashMap<Integer,ArrayList<Integer>>row,HashMap<Integer,ArrayList<Integer>>col){

        String key = x + "," + y;

        vis.add(key);

        for(int j : row.getOrDefault(x,new ArrayList<>())){

            String nkey = x + "," + j;

            if(!vis.contains(nkey)){
                dfs(x,j,vis,row,col);
            }

        }

        for(int i : col.getOrDefault(y,new ArrayList<>())){

            String nkey = i + "," + y;

            if(!vis.contains(nkey)){
                dfs(i,y,vis,row,col);
            }

        }

    }

}
