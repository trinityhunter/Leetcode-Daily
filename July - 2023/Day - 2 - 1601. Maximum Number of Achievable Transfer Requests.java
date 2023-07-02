class Solution {

    public int helper(int[][] requests, int[] arr, int start, int count, int n){

        if(start == requests.length){
            for(int i=0; i<n; i++){
                if(arr[i] != 0){
                    return 0;
                }
            }
            return count;
        }
        
        arr[requests[start][0]]--;

        arr[requests[start][1]]++;

        int pick = helper(requests, arr, start + 1, count + 1, n);
        
        arr[requests[start][0]]++;

        arr[requests[start][1]]--;

        int notPick = helper(requests, arr, start + 1, count, n);

        return Math.max(pick, notPick);

    }

    public int maximumRequests(int n, int[][] requests) {

        int[] arr = new int[n];

        return helper(requests, arr, 0, 0, n);

    }

}
