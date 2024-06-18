class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = profit.length;

        int[][] job = new int[n][2];

        for(int i=0; i<n; i++){
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }

        Arrays.sort(job, (a, b) -> a[0] - b[0]);

        Arrays.sort(worker);

        int j = 0, res = 0, best = 0;

        for(int i=0; i<worker.length; i++){

            while(j<n && worker[i]>=job[j][0]) {
                best = Math.max(best, job[j][1]);
                j++;
            }

            res += best;

        }

        return res;

    }
    
}
