class Solution {

    public List<List<String>> groupAnagrams(String[] strs){
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            char []arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            
            if(hm.containsKey(key)){
                List<String> al = hm.get(key);
                al.add(strs[i]);
                hm.put(key, al);
            }
            else{
                List<String> al = new ArrayList<>();
                al.add(strs[i]);
                hm.put(key, al);
            }
        }
        
        // System.out.println(hm);
        
        List<List<String>> ma = new ArrayList<>();
        
        for(String key: hm.keySet()){
            ma.add(hm.get(key));
        }
        
        return ma;
        
    }
    
}
