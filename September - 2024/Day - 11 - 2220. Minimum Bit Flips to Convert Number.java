class Solution {

    public int minBitFlips(int st, int g) {
        
        int xr = st ^ g;

        int c = 0;
       
        while(xr != 0){
            c += xr & 1; 
            xr >>= 1; 
        }

        return c;

    }
    
}
