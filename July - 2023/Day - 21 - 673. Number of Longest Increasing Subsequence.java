class Solution {

    public int findNumberOfLIS(int[] arr){

        int n = arr.length;
    
        int[] dp = new int[n];

        int[] count = new int[n];
        
        Arrays.fill(dp, 1);

        Arrays.fill(count, 1);
        
        int max = 1;
        
        for(int i=0; i<=n-1; i++){
            for(int j=0; j<=i-1; j++){
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if(arr[j] < arr[i] && dp[j] + 1 == dp[i]){
                    count[i] = count[i] + count[j];
                }
            }

            max = Math.max(max, dp[i]);

        }
        
        int ans = 0;
        
        for(int i=0; i<=n-1; i++){
            if(dp[i] == max){
                ans += count[i];
            } 
        }
        
        return ans;

    }

}
