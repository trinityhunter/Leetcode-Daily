class Solution {

    public static int helper(String answerKey, char ch, int k){

        int i = 0;

        int j = 0;

        int count = 0;

        int max = 0;

        while(j<answerKey.length()){

            if(answerKey.charAt(j) == ch){
                count++;
            }

            if(count<=k){
                max = Math.max(max, j-i+1);
            }

            if(count>k){

                while(count>k){
                    if(answerKey.charAt(i) == ch){
                        count--;
                    }
                    i++;
                }

            }

            j++;

        }

        return max;

    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        return Math.max(helper(answerKey, 'T', k), helper(answerKey, 'F', k));

    }

}
