class Solution {

    public int pivotInteger(int n) {
        
        int[] pre = new int[n];
        
        int pr = 1;
        
        for(int i=0; i<n; i++){
            if(i == 0){
                pre[i] = 1;
            }
            else{
                pre[i] = pre[i-1] + i + 1;
            }
            // System.out.println(pre[i]);
        }
        
        int[] suf = new int[n];
        
        for(int i=0; i<n; i++){
            if(i == 0){
                suf[i] = pre[n-1];
            }
            else{
                suf[i] = suf[i-1] - i;
            }
            System.out.println(suf[i]);
        }
        
        for(int i=0; i<n; i++){
            if(pre[i] == suf[i]){
                return i+1;
            }
        }
        
        return -1;
        
    }
    
}
