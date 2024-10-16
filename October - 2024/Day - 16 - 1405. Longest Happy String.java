class Solution {

    public String longestDiverseString(int a, int b, int c){

        StringBuilder sb = new StringBuilder();
        
        int totalLength = a + b + c;

        int aStreak = 0;
        int bStreak = 0;
        int cStreak = 0;
        
        for(int i = 0; i < totalLength; i++){
            if((a >= b && a >= c && aStreak != 2) || (bStreak == 2 && a > 0) || (cStreak == 2 && a > 0)){
                sb.append("a");
                a--;
                aStreak++;
                bStreak = 0;
                cStreak = 0;  
            } 
            else if((b >= a && b >= c && bStreak != 2) || (aStreak == 2 && b > 0) || (cStreak == 2 && b > 0)){
                sb.append("b");
                b--;
                bStreak++;
                aStreak = 0;
                cStreak = 0;
            } 
            else if((c >= a && c >= b && cStreak != 2) || (bStreak == 2 && c > 0) || (aStreak == 2 && c > 0)){
                sb.append("c");
                c--;
                cStreak++;
                aStreak = 0;
                bStreak = 0;  
            }
        }

        return sb.toString();

    }

}
