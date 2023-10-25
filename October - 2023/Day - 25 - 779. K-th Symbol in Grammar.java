class Solution {

    public int kthGrammar(int n, int k) {

        if(n == 1){
            return 0;
        }

        int parent = kthGrammar(n-1, (k/2 + k%2));

        boolean iskOdd = k % 2 == 1;

        if(parent == 1){
            return iskOdd ? 1 : 0;
        }
        else{
            return iskOdd ? 0 : 1;
        }
        
    }

}
