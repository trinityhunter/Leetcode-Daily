class Solution {

    public boolean isPossible(int x, int N, int[] arr){

        int c = 0;

        for(int i=0; i<arr.length; i++){

            if(arr[i] % x == 0){
                c += (arr[i]/x);
            }
            else{
                c+=(1+ arr[i]/x);
            }

        }

        if(c<=N){
            return true;
        }

        return false;

    }

    public int minimizedMaximum(int n, int[] quantities) {

        int m = quantities.length;

        int start = 1, end = 0, ans = Integer.MAX_VALUE;

        for(int x: quantities){
            end = Math.max(end, x);
        }

        while(start <= end){

            int mid = start+(end-start)/2;

            if(isPossible(mid, n, quantities) == true){

                ans = Math.min(ans, mid);

                end = mid-1;

            }
            else{
                start = mid+1;
            }

        }

        return ans;

    }
    
}
