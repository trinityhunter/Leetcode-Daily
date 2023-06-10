class Solution {

    public static long getHelp(int a, int num) {
        
        long an = 0;
        
        long extraOnes = 0;

        long ans = 0;

        if(num >= a){
            an = 1;
            extraOnes = num - a;
        } 
        else if(num < a){
            extraOnes = 0;
            an = a - num + 1;
        }
        
        ans = ((an + a) * (a - an + 1)) / 2;
        
        ans += extraOnes;
        
        return ans;

    }

    public static int helper(int max, int idx, int n) {
        
        long ans = getHelp(max - 1, idx) + getHelp(max, n - idx);

        if(ans>1000000000){
            return 1000000001;
        } 
        else{
            return (int)ans;
        }

    }

    public int maxValue(int n, int index, int maxSum) {
        
        int low = 1;
        
        int mid = 0;
        
        int high = 1000000000;

        while(low <= high){

            mid = (low + high)/2;
            
            if(helper(mid, index, n) > maxSum){ 
                high = mid - 1;
            }
            else if(helper(mid + 1, index, n)  <= maxSum){
                low = mid + 1;
            } 
            else {
                break;
            }

        }
        
        return mid;

    }

}
