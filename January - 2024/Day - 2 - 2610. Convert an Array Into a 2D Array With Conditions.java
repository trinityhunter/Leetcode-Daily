public class Solution {

    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();

        for(int x: nums){
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        while(!mp.isEmpty()){

            List<Integer> keysToErase = new ArrayList<>();
            
            for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
                int key = entry.getKey();
                temp.add(key);
                entry.setValue(entry.getValue() - 1);
                if(entry.getValue() == 0){
                    keysToErase.add(key);
                }
            }

            for(int key: keysToErase){
                mp.remove(key);
            }

            ans.add(new ArrayList<>(temp));

            temp.clear();

        }

        return ans;

    }

}
