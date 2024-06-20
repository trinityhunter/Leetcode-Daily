class Solution {

    static boolean find(int arr[], int x, int m){

        int n = arr.length;

        int b = 1;

        int prev = arr[0];

        for(int i=1; i<n; i++){
            if(arr[i]-prev>=x){
                b++;
                prev = arr[i];
            }
        }

        if(b >= m){
            return true;
        }

        return false;

    }

    public int maxDistance(int[] arr, int m) {

        Arrays.sort(arr);

        int n = arr.length;

        int st = 1;

        int end = arr[n-1]-arr[0];

        int ans = -1;

        while(st<=end){

            int mid = st+(end-st)/2;

            if(find(arr,mid,m)){
                ans = mid;
                st = mid+1;
            }
            else{
                end = mid-1;
            }

        }

        return ans;

    }
    
}
