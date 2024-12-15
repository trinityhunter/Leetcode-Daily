class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int[] c: classes){

            int pass = c[0];
            
            int total = c[1];

            double improvement = ((double)(pass + 1) / (total + 1)) - ((double) pass / total);

            pq.offer(new double[]{improvement, pass, total});

        }
        
        while(extraStudents > 0){
            
            double[] top = pq.poll();
            
            double improvement = top[0];
            
            int pass = (int) top[1];
            
            int total = (int) top[2];
            
            pass++;
            total++;
            
            double newImprovement = ((double)(pass + 1) / (total + 1)) - ((double) pass / total);

            pq.offer(new double[]{newImprovement, pass, total});

            extraStudents--;

        }

        double totalRatio = 0;

        while(!pq.isEmpty()){
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;

    }
    
}
