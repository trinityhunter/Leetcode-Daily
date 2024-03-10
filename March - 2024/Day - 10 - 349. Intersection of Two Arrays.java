class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        
        for(int i=0; i<nums1.length; i++){
            arr1.add(nums1[i]);
        }
        
        for(int i=0; i<nums2.length; i++){
            arr2.add(nums2[i]);
        }
        
        Collections.sort(arr1);
        Collections.sort(arr2);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<arr1.size(); i++){
            if(arr2.contains(arr1.get(i))){
                if(!ans.contains(arr1.get(i))){
                    ans.add(arr1.get(i));
                }
            }
        }
        
        int[] arr = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
    
}
