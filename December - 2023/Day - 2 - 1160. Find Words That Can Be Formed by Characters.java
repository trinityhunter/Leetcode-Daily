class Solution {
    public int countCharacters(String[] words, String chars) {
        
        HashMap<Character, Integer> hm1 = new HashMap<>();
        
        for(int i=0; i<chars.length(); i++){
            hm1.put(chars.charAt(i), hm1.getOrDefault(chars.charAt(i), 0) + 1);
        }
        
        int ans = 0;
        
        for(int i=0; i<words.length; i++){
            HashMap<Character, Integer> hm2 = new HashMap<>();
            
            for(int j=0; j<words[i].length(); j++){
                hm2.put(words[i].charAt(j), hm2.getOrDefault(words[i].charAt(j), 0) + 1);
            }
            
            int count = 0;
            
            for(char key: hm2.keySet()){
                if(hm1.containsKey(key) && hm2.get(key)<=hm1.get(key)){
                    count++;
                }
            }
            
            if(count == hm2.size()){
                ans += words[i].length();
            }
            
        }
        
        return ans;
        
    }
}
