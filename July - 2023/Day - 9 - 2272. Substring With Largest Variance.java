class Solution {

    public int largestVariance(String s) {
        
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[(int)(s.charAt(i) - 'a')]++;
        }
        
        int max = 0;

        for(int a=0; a<26; a++){
            for(int b=0; b<26; b++){

                int remA = freq[a];
                int remB = freq[b];

                if(a == b || remA == 0 || remB == 0){
                    continue;
                }
                
                int currB = 0;
                
                int currA = 0;

                for(int i=0; i<s.length(); i++){

                    int c = (int)(s.charAt(i) - 'a');
                    
                    if(c == b){
                        currB++;
                    }

                    if(c == a){
                        currA++;
                        remA--;
                    }
                    
                    if(currA>0){
                        max = Math.max(max, currB - currA);
                    }
                    
                    if(currB < currA &&  remA >= 1){
                        currB = 0;
                        currA = 0;
                    }

                }
            }
        }
        
        return max;

    }

}
