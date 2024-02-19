class Solution {

    public boolean isPowerOfTwo(int n) {
        
        // boolean ans = false;
        // for(int i=0; i<=Math.ceil(Math.pow(n, 0.5)); i++){
        //     if(Math.pow(2, i)==n){
        //         ans = true;
        //         break;
        //     }
        // }
        // return ans;
        
        // if(n==1){
        //     return true;
        // }
        // if(n==0 || n%2!=0){
        //     return false;
        // }
        // return isPowerOfTwo(n/2);
        
        return(( (n&(n-1)) == 0  && n > 0));
        
    }

}
