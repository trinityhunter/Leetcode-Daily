class Pair implements Comparable<Pair>{

    int key;

    int freq;

    Pair(int key, int freq){
        this.key = key;
        this.freq = freq;
    }

    public int compareTo(Pair o){
        return this.freq - o.freq;
    }

}

class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int key: hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }

        while(k>0){
            if(pq.peek().freq>k){
                return pq.size();
            }
            else{
                Pair rem = pq.remove();
                k -= rem.freq;
            }
        }

        return pq.size();

    }

}
