class Solution {

    public List<String> commonChars(String[] words) {
        
        HashMap<Character, Integer> hm1 = new HashMap<>();
        
        for(int i=0; i<words[0].length(); i++){
            hm1.put(words[0].charAt(i), hm1.getOrDefault(words[0].charAt(i), 0) + 1);
        }
        
        for(int i=1; i<words.length; i++){
            
            HashMap<Character, Integer> hm2 = new HashMap<>();
            HashMap<Character, Integer> temp = new HashMap<>();
            
            for(int j=0; j<words[i].length(); j++){
                hm2.put(words[i].charAt(j), hm2.getOrDefault(words[i].charAt(j), 0) + 1);
            }
            
            for(char key: hm1.keySet()){
                if(hm2.containsKey(key)){
                    temp.put(key, Math.min(hm1.get(key), hm2.get(key)));
                }
            }
            
            hm1 = temp;
            
        }
        
        List<String> arr = new ArrayList<>();
        
        for(char key: hm1.keySet()){
            for(int i=0; i<hm1.get(key); i++){
                arr.add(key+"");
            }
        }
        
        return arr;
        
    }
    
}
