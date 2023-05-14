public class Solution {
    
    public static int gcd(int a, int b){

        if(b == 0){
            return a;
        }

        return gcd(b, a % b);

    }
    
    public static int helper(List<Integer> nums, int state, int current){

        if(current == 0){
            return 0;
        }

        if(dp[state] != 0){
            return dp[state];
        }

        int result = 0;
        
        int n = nums.size();
        
        List<Integer> total = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if((state & (1 << i)) != 0){
                total.add(i);
            }
        }
        
        for(int i=0; i<total.size(); i++){
            for(int j=i+1; j<total.size(); j++){
                result = Math.max(result, gcd(nums.get(total.get(i)), nums.get(total.get(j))) * current  + helper(nums, (state & (~(1 << total.get(i)) & (~(1 << total.get(j))))), current - 1));
            }
        }
        
        return dp[state] = result;

    }

    public static int[] dp;
    
    public int maxScore(int[] nums) {

        int n = nums.length;

        dp = new int[1 << n];

        Arrays.fill(dp, 0);

        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            list.add(num);
        }

        return helper(list, (1 << n) - 1, n / 2);

    }

}
