class Solution {

    public long totalCost(int[] costs, int k, int candidates) {

        long ans = 0;

        int left = candidates - 1;
        
        int right = costs.length - candidates;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else{
                return a[1] - b[1];
            }

        });

        for(int i=0; i<=left && i<costs.length; i++){
            pq.add(new int[]{costs[i], i});
        }

        for (int i=costs.length-1; i>=0 && i>left && i>=right; i--) {
            pq.add(new int[]{costs[i], i});
        }

        while(left < right){

            if(k == 0){
                break;
            }

            int[] temp = pq.poll();

            if(temp[1] <= left){
                left++;
                if(left < right){
                    pq.add(new int[]{costs[left], left});
                }
            } 
            else if(temp[1] >= right){
                right--;
                if(left < right){
                    pq.add(new int[]{costs[right], right});
                } 
            }

            ans += temp[0];

            k--;

        }

        while(k>0){
            int[] temp = pq.poll();
            ans += temp[0];
            k--;
        }

        return ans;

    }

}
