class Solution {

    public static double helper(double x, int n){

        if(n == 0){
            return 1.0;
        } 
        else if(n % 2 == 1){
            return x * helper(x, n - 1);
        } 
        else if(n % 2 == 0){
            return helper(x * x, n / 2);
        } 
        else{
            return 1/helper(x, -n);
        }

    }
    
    public double myPow(double x, int n) {

        return helper(x, n);
        
    }

}
