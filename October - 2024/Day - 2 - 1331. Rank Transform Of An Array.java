class Solution {

    public int[] arrayRankTransform(int[] arr) {

        HashMap<Integer, Integer> valueToRank = new HashMap<>(); 

        int[] set = Arrays.stream(arr).distinct().sorted().toArray();
        
        for(int i=0; i<set.length; i++){
            valueToRank.put(set[i], i+1);
        }
        
        for(int i=0; i<arr.length; i++){
            arr[i] = valueToRank.get(arr[i]);
        }

        return arr;

    }

}
