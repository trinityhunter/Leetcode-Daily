class Solution {

    public int countMaxOrSubsets(int[] nums) {

        int length = nums.length;

        int[] ans = new int[1];

        int cur = 0;

        int max = 0;

        for(int i: nums){
            max |= i;
        }

        dfs(nums, cur, 0, max, ans, length);

        return ans[0];

    }

    public void dfs(int[] nums, int cur, int ind, int max, int[] ans, int length){

        if(cur == max){
            
            ans[0] += 1 << (length - ind);

            return;

        }

        if(ind == length){
            return;
        }

        dfs(nums, cur | nums[ind], ind + 1, max, ans, length);

        dfs(nums, cur, ind + 1, max, ans, length);

    }
    
}
