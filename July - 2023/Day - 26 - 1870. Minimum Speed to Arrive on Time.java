class Solution {

    public static boolean helper(int[] dist, double hours, int speed){

        double time = 0;

        for(int i=0; i<dist.length; i++){
            if(i == dist.length-1){
                time += ((double)dist[i]/(double)speed);
            }
            else{
                time += Math.ceil(((double)dist[i]/(double)speed));
            }
        }

        if(time <= hours){
            return true;
        }

        return false;

    }

    public int minSpeedOnTime(int[] dist, double hour) {

       int low = 1;

       int high = 10000000;

        while(low<high){

           int mid = (low + high) / 2;
           
            if(helper(dist, hour, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }

        }
     
        if(helper(dist, hour, low)){
            return low;
        }

        return -1;

    }
    
}
