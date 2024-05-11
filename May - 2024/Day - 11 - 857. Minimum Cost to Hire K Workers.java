class Solution {

    public double mincostToHireWorkers(int[] q, int[] w, int K) {

        double[][] workers = new double[q.length][2];

        for (int i = 0; i < q.length; i++){
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        }
            
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        double ans = Double.MAX_VALUE;
        
        double sum = 0;

        PriorityQueue<Double> pq = new PriorityQueue<>();

        for (double[] worker: workers){

            sum += worker[1];

            pq.add(-worker[1]);

            if (pq.size() > K){
                sum += pq.poll();
            }
            if(pq.size() == K){
                ans = Math.min(ans, sum * worker[0]);
            }

        }

        return ans;

    }

}
