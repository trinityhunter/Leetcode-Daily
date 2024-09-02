class Solution {

    public int chalkReplacer(int[] chalk, int k) {

        long tot = 0;

        for(int ch: chalk){
            tot += ch;
        }

        k %= tot;

        for(int i=0; i<chalk.length; i++){
            
            if(k < chalk[i]){
                return i;
            }

            k -= chalk[i];
        
        }

        return -1;

    }
    
}
