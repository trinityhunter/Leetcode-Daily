class Solution {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double)A[a[0]] / (double)A[a[1]], (double)A[b[0]] / (double)A[b[1]]));

        pq.offer(new int[]{0, A.length - 1});

        for (int i = 0; i < K - 1; i++) {

            int[] cur = pq.poll();

            if (cur[0] + 1 < A.length && cur[1] == A.length - 1) {
                pq.offer(new int[]{cur[0] + 1, cur[1]});
            }

            if (cur[1] - 1 >= 0) {
                pq.offer(new int[]{cur[0], cur[1] - 1});
            }
            
        }

        int[] cur = pq.poll();

        return new int[]{A[cur[0]], A[cur[1]]};

    }

}
