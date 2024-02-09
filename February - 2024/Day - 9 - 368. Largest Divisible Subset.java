class Solution {

    public static void helper(int nums[], int i, int prev, List<Integer> ans){
        
        if(i>=nums.length){
            if(ans.size() > arr.size()){
                arr.clear();

                arr.addAll(ans);
            }

            return;
        }
        
        if(ans.size()>dp[i] && (nums[i]%prev==0 || prev%nums[i]==0)){

            dp[i] = ans.size();

            ans.add(nums[i]);

            helper(nums, i+1, nums[i], ans);

            ans.remove(ans.size()-1);

        }
        
        helper(nums, i+1, prev, ans);  

    }

    public static List<Integer> arr;

    public static int[] dp;

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        dp = new int[nums.length+1];

        List<Integer> ans=new ArrayList<>();

        arr = new ArrayList<>();

        Arrays.fill(dp, -1);

        helper(nums, 0, 1, ans);

        return arr;
        
    }
    
}
