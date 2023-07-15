class Solution {
    
    public static int finder(int[][] events, int target){

        int low = 0;

        int high = events.length-1;
        
        int ans = events.length;

        while(low <= high){

            int mid = low + (high-low)/2;
            
            if(events[mid][0] > target){
                ans = mid;
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
            
        }
        
        return ans;

    }
    
    public static int helper(int[][] events, int ind, int k) {
        
        if(k == 0 || ind == events.length){
            return 0;
        }
        
        if(dp[ind][k]!=null){
            return dp[ind][k];
        }

        int notPick = helper(events, ind + 1, k);
        
        int pick = 0;

        int temp = finder(events, events[ind][1]);

        pick = events[ind][2] + helper(events, temp, k-1);
        
        return dp[ind][k] = Math.max(pick, notPick);
        
    }

    public static Integer[][] dp;
    
    public int maxValue(int[][] events, int k) {

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        dp = new Integer[events.length][k + 1];
        
        return helper(events, 0, k);
        
    }

}
