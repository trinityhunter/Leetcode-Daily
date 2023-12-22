class Solution {

    public int maxScore(String s){

        int len = s.length();

        int score = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++){
            score = Math.max(score, counter(s.substring(0, i), 0) + counter(s.substring(i, len), 1));
        }

        return score;
        
    }

    private int counter(String str, int type) {
        int res = 0;
        int len = str.length();
        if (type == 0) {
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '0') {
                    res++;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '1') {
                    res++;
                }
            }
        }
        return res;
    }
}
