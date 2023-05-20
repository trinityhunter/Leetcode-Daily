class Solution {

    public static HashMap<String, ArrayList<Pair>> graph;

    public class Pair{

        String v;

        double w;

        Pair(String v, double w){
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return v + " " + w;
        }

    }
    
    public static double helper(String src, String dest, HashSet<String> vis){

        vis.add(src);

        if(src.equals(dest)){
            return 1;
        }

        double ans = 1;

        for(Pair edge: graph.get(src)){

            if(!vis.contains(edge.v)){

                double prev = helper(edge.v, dest, vis);

                if(prev > 0){
                    return edge.w * prev;
                }
            }

        }

        return -1.0;

    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        graph = new HashMap<>();

        double[] ans = new double[queries.size()];

        for(int i=0; i<equations.size(); i++){

            String u = equations.get(i).get(0);

            String v = equations.get(i).get(1);

            double w = values[i];

            graph.putIfAbsent(u, new ArrayList<>());

            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, w));

            graph.get(v).add(new Pair(u, 1/w));

        }
        
        for(int i=0; i<queries.size(); i++){

            String u = queries.get(i).get(0);
            
            String v = queries.get(i).get(1);

            double q = -1.0;

            if(graph.containsKey(u)){
                q = helper(u, v, new HashSet<>());
            }
            
            ans[i] = q;

        }
        
        return ans;

    }

}
