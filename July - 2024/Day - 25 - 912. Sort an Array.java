class Solution {
    
    public static int[] mergeSortedArrays(int[] left, int[] right){
        
        int[] arr = new int[left.length + right.length];
        
        int ind = 0, i = 0, j = 0;
        
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                arr[ind] = left[i];
                i++;
                ind++;
            }
            else{
                arr[ind] = right[j];
                j++;
                ind++;
            }
        }
        
        while(j<right.length){
            arr[ind] = right[j];
            j++;
            ind++;
        }
        
        while(i<left.length){
            arr[ind] = left[i];
            i++;
            ind++;
        }
        
        return arr;
        
    }
    
    public static int[] mergeSort(int[] nums, int low, int high){
        
        if(low == high){
            int[] ans = new int[1];
            ans[0] = nums[low];
            return ans;
        }
        
        int mid = (low+high)/2;
        
        int[] left = mergeSort(nums, low, mid);
        
        int[] right = mergeSort(nums, mid+1, high);
        
        int[] arr = mergeSortedArrays(left, right);
        
        return arr;
        
    }
    
    public int[] sortArray(int[] nums) {
        
        return mergeSort(nums, 0, nums.length-1);
        
    }
}
