class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        
        for(int i=0; i<nums1.length; i++){
            hm1.put(nums1[i], hm1.getOrDefault(nums1[i], 0) + 1);
        }
        
        for(int i=0; i<nums2.length; i++){
            hm2.put(nums2[i], hm2.getOrDefault(nums2[i], 0) + 1);
        }
        
        List<Integer> diff1 = new ArrayList<>();
        
        List<Integer> diff2 = new ArrayList<>();
        
        for(int key: hm1.keySet()){
            if(!hm2.containsKey(key)){
                diff1.add(key);
            }
        }
        
        for(int key: hm2.keySet()){
            if(!hm1.containsKey(key)){
                diff2.add(key);
            }
        }
        
        List<List<Integer>> arr = new ArrayList<>();
        
        arr.add(diff1);
        
        arr.add(diff2);
        
        return arr;
        
    }
    
}
