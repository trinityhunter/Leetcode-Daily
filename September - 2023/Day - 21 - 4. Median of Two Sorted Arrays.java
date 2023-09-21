class Solution {

    public static int[] mergeArrays(int[] nums1, int[] nums2){

        int[] arr = new int[nums1.length + nums2.length];
        
        int i=0;
        
        int j=0;
        
        int idx = 0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[idx] = nums1[i];
                i++;
                idx++;
            }
            else{
                arr[idx] = nums2[j];
                j++;
                idx++;
            }
        }
        
        while(j!=nums2.length){
            arr[idx] = nums2[j];
            idx++;
            j++;
        }
        
        while(i!=nums1.length){
            arr[idx] = nums1[i];
            idx++;
            i++;
        }
        
        return arr;

    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = mergeArrays(nums1, nums2);
        
        double ans;
        
        if(arr.length%2==1){
            ans = arr[arr.length/2];
        }
        else{
            ans = (double)(arr[arr.length/2-1] + arr[arr.length/2])/2;
        }
        
        return ans;

    }

}
