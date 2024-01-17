class Solution {

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int key: hm.keySet()){
            set.add(hm.get(key));
        }

        if(set.size() == hm.size()){
            return true;
        }

        return false;

    }

}
