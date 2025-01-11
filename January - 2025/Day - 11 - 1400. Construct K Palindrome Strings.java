class Solution {
    public boolean canConstruct(String s, int k) {
        
        if(s.length() < k){
            return false;
        }
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int count = 0;
        
        for(char key: hm.keySet()){
            if(hm.get(key)%2==1){
                count++;
            }
        }
        
        if(count>k){
            return false;
        }
        
        return true;
        
    }
}
