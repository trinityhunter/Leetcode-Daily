class Solution {
    
    public int partitionString(String s) {
        
        int[] dp = new int[s.length()];
        
        for(int i=0; i<dp.length; i++){
            if(i == 0){
                dp[i] = 1;
            }
            else{
                int ind = i-1;
                int pre = dp[i-1];
                
                while(ind>=0){
                    if(pre != dp[ind]){
                        break;
                    }
                    ind--;
                }
                ind++;
                
                if(s.substring(ind, i).indexOf(s.charAt(i)) != -1){
                    dp[i] = dp[i-1] + 1;
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }
        
        return dp[s.length()-1];
        
    }
}
