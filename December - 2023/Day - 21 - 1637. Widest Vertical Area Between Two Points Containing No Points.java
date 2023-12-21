class Solution {
    public static int[] mergeTwoSortedArrays(int[] ls, int[] rs){
        
        int[] arr = new int[ls.length + rs.length];
        
        int i=0, j=0, idx=0;
        
        while(i<ls.length && j<rs.length){
            if(ls[i]<rs[j]){
                arr[idx] = ls[i];
                i++;
                idx++;
            }
            else{
                arr[idx] = rs[j];
                j++;
                idx++;
            }
        }
        
        while(j<rs.length){
            arr[idx] = rs[j];
            j++;
            idx++;
        }
        
        while(i<ls.length){
            arr[idx] = ls[i];
            i++;
            idx++;
        }
        
        return arr;
    }
    
    public static int[] mergeSort(int[] arr, int low, int high){
        
        if(low == high){
            int[] temp = new int[1];
            temp[0] = arr[low];
            return temp;
        }
        
        int mid = (low+high)/2;
        
        int[] ls = mergeSort(arr, low, mid);
        
        int[] rs = mergeSort(arr, mid+1, high);
        
        int[] ans = mergeTwoSortedArrays(ls, rs);
        
        return ans;
    }
    
    public int maxWidthOfVerticalArea(int[][] points) {
        
        int[] arr = new int[points.length];
        
        for(int i=0; i<points.length; i++){
            arr[i] = points[i][0];
        }
        
        int[] ans = mergeSort(arr, 0, arr.length-1);
        
        int max = 0;
        
        int diff = 0;
        
        for(int i=0; i<ans.length-1; i++){
            diff = ans[i+1] - ans[i];
            
            max = Math.max(max, diff);
        }
        
        return max;
    }
}
