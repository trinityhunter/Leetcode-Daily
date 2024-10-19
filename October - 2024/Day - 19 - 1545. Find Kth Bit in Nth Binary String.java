class Solution {

    public char findKthBit(int n, int k){
    
        int length = (1 << n) - 1;
        
        return helper(n, k);

    }

    private char helper(int n, int k){

        if(n == 1){
            return '0';
        }
        
        int mid = (1 << (n - 1));
        
        if(k == mid){
            return '1';
        } 
        else if(k < mid){
            return helper(n - 1, k);
        } 
        else{
            
            char res = helper(n - 1, mid - (k - mid));

            return res == '0' ? '1' : '0';

        }

    }
    
}
