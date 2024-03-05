class Solution {

    public int minimumLength(String s) {

        int low = 0;

        int high = s.length()-1;

        int n = s.length();

        while(low<high){
            if(s.charAt(low) == s.charAt(high)){
                char c = s.charAt(low);
                if(low<n){
                    while(s.charAt(low) == c){
                        low++;
                        if(low>=n){
                            break;
                        }
                    }
                }
                
                if(high>=0){
                    while(s.charAt(high) == c){
                        high--;
                        if(high<0){
                            break;
                        }
                    }
                }
                
            }
            else{
                break;
            }
        }

        if(high - low + 1 < 0){
            return 0;
        }

        return high - low + 1;
    
    }

}
