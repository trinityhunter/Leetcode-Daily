class Solution {
    
    public String predictPartyVictory(String senate) {
        
        int r = 0;
        
        int d = 0;

        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                r++;
            } 
            else{
                d++;
            }
        }
        
        boolean[] banned = new boolean[senate.length()];
        
        int br = 0;
        
        int bd = 0;

        while(r>0 && d>0){
            for(int i=0; i<senate.length(); i++){

                if(banned[i]){
                    continue;
                }
                
                if(senate.charAt(i) == 'R'){
                    if(br>0){
                        r--;
                        banned[i] = true;
                        br--;
                    } 
                    else{
                        bd++;
                    }
                } 
                else{
                    if(bd > 0){
                        d--;
                        banned[i] = true;
                        bd--;
                    } 
                    else{
                        br++;
                    }
                }

            }
        }
        
        return (r>0) ? "Radiant" : "Dire";

    }

}
