class Solution {

    HashMap<String, Integer> map;

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        map = new HashMap<>();
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                res += dfs(nums, j+1, j, (long)nums[j]-(long)nums[i]);
            }
        }
        return res;
    }

    public int dfs(int[] nums, int cur, int pre, long diff){

        if(cur == nums.length){
            return 0;
        }

        String key = cur+"_"+diff;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int res = 0;

        for(int i=cur; i<nums.length; i++){
            if((long)nums[i]-(long)nums[pre] == diff){
                res += 1+dfs(nums, i+1, i, diff);
            }
        }

        map.put(key, res);

        return res;

    }
    
}
