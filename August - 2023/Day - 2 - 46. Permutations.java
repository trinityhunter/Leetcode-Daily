class Solution {
    
    public static void helper(int[] nums, List<List<Integer>> ma, List<Integer> ca){

        if(ca.size() == nums.length){
            ma.add(new ArrayList<>(ca));
        }
        
        for(int i=0; i<nums.length; i++){

            if(ca.contains(nums[i])){
                continue;
            }
                
            ca.add(nums[i]);
            
            helper(nums, ma, ca);
            
            ca.remove(ca.size()-1);

        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ma = new ArrayList<>();
        
        helper(nums, ma, new ArrayList<>());
        
        return ma;

    }   
    
}
