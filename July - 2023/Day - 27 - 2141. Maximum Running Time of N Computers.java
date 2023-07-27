public class Solution {

    public long maxRunTime(int n, int[] batteries) {

        long sum = 0;

        for(int i=0; i<batteries.length; i++){
            sum += batteries[i];
        }

        long low = 1;
        
        long high = sum/n;
        
        while(low < high){
            
            long target = high - (high - low)/2;

            long extra = 0;

            for(int i=0; i<batteries.length; i++){
                extra += Math.min(batteries[i], target);
            }

            if(extra >= (long)(n * target)){
                low = target;
            }
            else{
                high = target - 1;
            }

        }

        return low;

    }

}
