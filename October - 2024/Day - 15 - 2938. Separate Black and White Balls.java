class Solution {

    public long minimumSteps(String s) {

        char[] ar = s.toCharArray();

        long c = 0;

        for(int i=ar.length-1; i>=0; i--){
            if(ar[i] == '1'){
                continue;
            }

            boolean b = false;

            for(int j=i-1; j>=0; j--){

                if(ar[j] == '1'){
                    c += Math.abs(j-i);
                    ar[i] = '1';
                    ar[j] = '0';
                    i--;
                }

                if(j == 0){ 
                    b = !b;
                }

            }

            if(b){
                break;
            }

        }

        return c;

    }
    
}
