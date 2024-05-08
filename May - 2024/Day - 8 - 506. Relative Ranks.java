class Solution {

    public String[] findRelativeRanks(int[] score) {
        
        int[] og = new int[score.length];
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<score.length; i++){
            og[i] = score[i];
            max = Math.max(max, score[i]);
        }
        
        Arrays.sort(score);
        
        String[] temp = new String[max+1];
        
        int ind = 4;
        
        for(int i=score.length-1; i>=0; i--){
            if(i == score.length-1){
                temp[score[i]] = "Gold Medal";
            }
            else if(i == score.length-2){
                temp[score[i]] = "Silver Medal";
            }
            else if(i == score.length-3){
                temp[score[i]] = "Bronze Medal";
            }
            else{
                temp[score[i]] = ind + "";
                ind++;
            }
        }
        
        String[] ans = new String[score.length];
        
        for(int i=0; i<og.length; i++){
            ans[i] = temp[og[i]];
        }
        
        return ans;
        
    }
    
}
