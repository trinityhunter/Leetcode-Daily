class pair{

    int node; 
    int weigth;

    pair(int node, int weigth){

        this.node= node;
        this.weigth = weigth;
        
    }
    
}

class tuple{

    int first;
    int second;
    int third;

    tuple(int first, int second ,int third){

        this.first = first;
        this.second = second;
        this.third = third;

    }

}
class Solution {
    
    public int findCheapestPrice(int n,int flights[][],int src,int dst,int k) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m =  flights.length;

        for(int i = 0;i<m;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }

        Queue<tuple> q = new LinkedList<>();

        int dist[] = new int[n];

        for(int i = 0;i<n;i++){
            dist[i] = (int)(1e9);
        }

        q.add(new tuple( 0, src ,0));
        dist[src] = 0;

        while(!q.isEmpty()){
            int stops = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            
            q.remove();
            
            if(stops>k) continue;
            
            for(pair it : adj.get(node)){
                int adjnode = it.node;
                int weight = it.weigth;
                
                if(cost + weight < dist[adjnode] && stops <= k){
                    dist[adjnode] = cost+ weight;
                    q.add(new tuple( stops+1 , adjnode , dist[adjnode]));
                }
            }
        }

        if(dist[dst] == (int)(1e9)) return -1;
        
        return dist[dst];
        
    }

}
