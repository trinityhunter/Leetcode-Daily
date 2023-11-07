class Solution {

    public int eliminateMaximum(int[] dist, int[] speed) {

        double[] arr = new double[dist.length];

        for(int i=0; i<dist.length; i++){
            arr[i] = (double)dist[i]/speed[i];
        }

        Arrays.sort(arr);

        int count = 0;

        for(int i=0; i<arr.length; i++){

            if((arr[i]-i)>0){
                count++;
            }
            else{
                return count;
            }

        }

        return count;

    }

}
