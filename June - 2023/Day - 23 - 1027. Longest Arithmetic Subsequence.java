class Solution {

    public int longestArithSeqLength(int[] nums) {

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        int ans = 0;

        for(int i=0; i<nums.length; i++){

            Map<Integer, Integer> tMap = new HashMap<>();

            for(int j=0; j<i; j++){

                int diff = nums[i] - nums[j];

                int max = 2;

                if(map.get(j).containsKey(diff)) {
                    max = map.get(j).get(diff) + 1;
                }

                ans = Math.max(ans, max);

                tMap.put(diff, max);

            }

            map.put(i, tMap);
            
        }
        
        return ans;

    }

}
