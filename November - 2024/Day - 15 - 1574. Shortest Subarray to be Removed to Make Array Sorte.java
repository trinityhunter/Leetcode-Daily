class Solution {

    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;
        
        int right = n - 1;

        while(right > 0 && arr[right - 1] <= arr[right]){
            right--;
        }
        
        if(right == 0){
            return 0;
        }
        
        int minLength = right;
        
        for(int left = 0; left < n; left++){

            if(left > 0 && arr[left - 1] > arr[left]){
                break;
            }
            
            while(right < n && arr[left] > arr[right]){
                right++;
            }
            
            int currentLength = right - left - 1;

            minLength = Math.min(minLength, currentLength);

        }
        
        return minLength;

    }
    
}
