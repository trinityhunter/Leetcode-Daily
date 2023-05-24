class Pair {
    
    int i; 
    
    int j;
    
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }

}

class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {

        Pair[] arr = new Pair[nums1.length];

        for(int i=0; i<nums1.length; i++){
            arr[i] = new Pair(nums1[i], nums2[i]);
        }

        Arrays.sort(arr , (a , b)->b.i - a.i);

        long sum = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b)->a.j - b.j);

        long ans = 0;

        for(int i=0; i<nums1.length; i++){

            pq.offer(arr[i]);

            sum += arr[i].i;

            if(pq.size() > k) {
                Pair p = pq.poll();
                sum -= p.i;
            }

            if(pq.size() == k){
                long a = sum * pq.peek().j;
                ans = Math.max(ans, a);
            }

        }

        return ans;

    }

}
