class Pair{

    int node;

    int time;

    public Pair(int node, int time){

        this.node = node;
        this.time = time;

    }

}

class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<manager.length; i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }

        int max = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(headID, 0));

        while(q.size()>0){

            int count = q.size();

            for(int i=0; i<count; i++){

                Pair rem = q.remove();

                max = Math.max(max, rem.time);

                for(int child: adj.get(rem.node)){
                    q.add(new Pair(child, rem.time + informTime[rem.node]));
                }

            }

        }

        return max;

    }

}
