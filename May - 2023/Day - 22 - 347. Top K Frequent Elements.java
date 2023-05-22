class Pair implements Comparable<Pair>{

    int key;

    int freq;

    Pair(int key, int freq){
        this.key = key;
        this.freq = freq;
    }

    public int compareTo(Pair o){
        return o.freq - this.freq;
    }

}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq =  new PriorityQueue<>();

        for(int key: hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }

        int[] arr = new int[k];

        int ind = 0;

        while(pq.size()>0 && k>0){
            arr[ind] = pq.remove().key;
            k--;
            ind++;
        }

        return arr;

    }

}
