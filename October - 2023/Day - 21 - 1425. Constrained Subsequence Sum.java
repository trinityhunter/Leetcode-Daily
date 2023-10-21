class Pair implements Comparable<Pair>{

    int ans;

    int i;

    Pair(int ans , int i){
        this.ans = ans;
        this.i = i;
    }

    public int compareTo(Pair o){
        return o.ans - this.ans;
    }

}

class Solution {

    public int constrainedSubsetSum(int[] a, int k) {

        int n = a.length;

        int dp[] = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int max = -1;

        for(int i = n - 1; i >= 0; i--){

            while(pq.size() > 0 && pq.peek().i > i + k){
                pq.poll();
            }

            if(pq.size() > 0){
                Pair pp = pq.peek();
                dp[i] = a[i] + pq.peek().ans;
            }
            else{
                dp[i] = a[i];
            }

            if(dp[i] > 0){
                pq.add(new Pair(dp[i] , i));
            }

            max = Math.max(max, dp[i]);

        }

        return max;

    }

}
