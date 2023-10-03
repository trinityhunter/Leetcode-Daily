class Solution {

    public int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int ans = 0;

        for(int num: nums){

            if(!hm.containsKey(num)){
                hm.put(num, 1);
            } 
            else{
                int x = hm.get(num);
                ans += x;
                hm.put(num, x + 1);
            }

        }

        return ans;

    }

}
