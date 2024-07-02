class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        
        boolean[] visited = new boolean[nums2.length];
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j] && visited[j] == false){
                    arr.add(nums1[i]);
                    visited[j] = true;
                    break;
                }
            }
        }
        
        int[] ans = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }
        
        return ans;
        
    }
    
}
