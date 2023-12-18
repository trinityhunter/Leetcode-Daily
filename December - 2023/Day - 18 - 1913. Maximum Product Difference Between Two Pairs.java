class Solution {
    public static int max(ArrayList<Integer>arr){
        int max = 0;
        
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)>max){
                max = arr.get(i);
            }
        }
        return max;
    }
    
    public static int min(ArrayList<Integer>arr){
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)<min){
                min = arr.get(i);
            }
        }
        return min;
    }
    
    public int maxProductDifference(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            arr.add(nums[i]);
        }
        
        int w = max(arr);
        arr.remove(Integer.valueOf(w));
        
        int x = max(arr);
        
        int y = min(arr);
        arr.remove(Integer.valueOf(y));
        
        int z = min(arr);
        
        return (w*x) - (y*z);
    }
}
