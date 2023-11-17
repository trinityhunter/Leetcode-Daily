class Solution {
//     public static int max(ArrayList<Integer> arr){
//         int max = 0;
        
//         for(int i=0; i<arr.size(); i++){
//             if(arr.get(i)>max){
//                 max = arr.get(i);
//             }
//         }
//         return max;
//     }
    
//     public static int min(ArrayList<Integer> arr){
//         int min = Integer.MAX_VALUE;
        
//         for(int i=0; i<arr.size(); i++){
//             if(arr.get(i)<min){
//                 min = arr.get(i);
//             }
//         }
//         return min;
//     }
    
    public int minPairSum(int[] nums) {
        
//         int maximum = 0;
        
//         ArrayList<Integer> arr = new ArrayList<>();
        
//         // List<Integer> arr = Arrays.asList(nums);
//         // Collections.addAll(arr, nums);
        
//         for(int i=0; i<nums.length; i++){
//             arr.add(nums[i]);
//         }
        
//         for(int i=0; i<(nums.length)/2; i++){
//             // int p1 = max(arr);
//             int p1 = Collections.max(arr);
//             arr.remove(Integer.valueOf(p1));
//             // int p2 = min(arr);
//             int p2 = Collections.min(arr);
//             arr.remove(Integer.valueOf(p2));
            
//             if((p1+p2)>maximum){
//                 maximum = (p1+p2);
//             }
//         }
//         return maximum;
        
        Arrays.sort(nums);
        
        int comp = 0;
        int max = 0;
        
        for(int i=0; i<(nums.length)/2; i++){
            comp = nums[i] + nums[nums.length-1-i];
            
            if(comp>max){
                max = comp;
            }
        }
        return max;
    }
}
