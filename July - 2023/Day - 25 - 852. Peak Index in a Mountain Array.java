class Solution {
    
    public static int helper(int[] arr, int low, int high){
        
        if(low == high){
            return low;
        }
        
        int mid = (low + high)/2;
        
        int left = helper(arr, low, mid);
        
        int right = helper(arr, mid+1, high);
        
        if(arr[left]>arr[right]){
            return left;
        }
        else{
            return right;
        }
        
    }
    
    public int peakIndexInMountainArray(int[] arr) {
        
        return helper(arr, 1, arr.length-2);
        
    }
}
