class Solution {
    
    public static boolean check(int l, int r, int[] nums){
        
        int[] arr = new int[r-l+1];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = nums[i+l];
        }
        
        Arrays.sort(arr);
        
        int diff = 0;
        
        for(int i=1; i<arr.length; i++){
            if(i == 1){
                diff = arr[i] - arr[i-1];
            }
            if(diff != arr[i] - arr[i-1]){
                return false;
            }
        }
        
        return true;
    }
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> arr = new ArrayList<>();
        
        for(int i=0; i<l.length; i++){
            arr.add(check(l[i], r[i], nums));
        }
        
        return arr;
    }
    
}
