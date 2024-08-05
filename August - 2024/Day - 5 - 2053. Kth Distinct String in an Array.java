class Solution {

    public String kthDistinct(String[] arr, int k) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(hm.get(arr[i]) == 1){
                count++;
            }
            if(count == k){
                return arr[i];
            }
        }
        
        return "";
        
    }
    
}
