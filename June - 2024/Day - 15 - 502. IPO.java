class Solution {

    class Pair implements Comparable<Pair>{

        int capital, profit;

        public Pair(int capital, int profit){

            this.capital = capital;
            this.profit = profit;

        }

        public int compareTo(Pair project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Pair[] p = new Pair[profits.length];

        for(int i=0; i<profits.length; i++){
            p[i] = new Pair(capital[i], profits[i]);
        }

        Arrays.sort(p);

        PriorityQueue<Integer> pq = new PriorityQueue<>(profits.length, Collections.reverseOrder());

        int count = 0;

        for(int i=0; i<k; i++){

            while(count<profits.length && p[count].capital <= w){
                pq.add(p[count++].profit);
            }

            if(pq.isEmpty()){
                break;
            }

            w += pq.poll();

        }

        return w;

    }

}
