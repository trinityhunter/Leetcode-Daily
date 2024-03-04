class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {

        int ans = 0;
        
        int score = 0;

        Arrays.sort(tokens);

        int i = 0;
        
        int j = tokens.length - 1;

        while(i <= j){

            if(tokens[i] > power){

                if(score == 0){
                    return ans;
                }
                else{
                    score--;
                    power += tokens[j];
                    j--;
                }
                
            }

            power -= tokens[i];

            i++;

            score++;

            ans = Math.max(ans, score);

        }

        return ans;

    }

}
