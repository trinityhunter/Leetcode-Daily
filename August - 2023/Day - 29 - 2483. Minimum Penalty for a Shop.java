class Solution {

    public int bestClosingTime(String customers) {

        int[] dp = new int[customers.length() + 1];

        for(int i=0; i<customers.length(); i++){
            if(customers.charAt(i)=='Y'){
                dp[0]++;
            }
        }

        int min = dp[0];
        
        int minPos = 0;

        for(int i=1; i<dp.length; i++){

            if(customers.charAt(i-1) == 'Y'){
                dp[i] = dp[i-1] - 1;
            }
            else{
                dp[i] = dp[i-1] + 1;
            }

            if(dp[i]<min){
                min = dp[i];
                minPos = i;
            }

        }

        return minPos;

    }

}
