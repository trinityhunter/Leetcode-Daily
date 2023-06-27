class Tuple implements Comparable<Tuple>{

    public int x;

    public int y;

    public int val;

    public Tuple(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    public int compareTo(Tuple o){
        return this.val - o.val; 
    }

}

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ma = new ArrayList<>();

        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for(int i=0; i<nums1.length; i++){
            pq.add(new Tuple(0, i, nums2[0]+nums1[i]));
        }

        for(int i=0; i<k; i++){

            if(pq.peek()==null){
                break;
            }

            Tuple rem = pq.remove();

            List<Integer> ca = new ArrayList<Integer>();

            ca.add(nums1[rem.y]);

            ca.add(nums2[rem.x]);

            ma.add(ca);

            if(rem.x == nums2.length-1){
                continue;
            }

            pq.offer(new Tuple(rem.x+1, rem.y, nums2[rem.x+1] + nums1[rem.y]));

        }

        return ma;

    }

}
