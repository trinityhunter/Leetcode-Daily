class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        
        String str = s1 + " " + s2;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        String temp = "";
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ' '){
                temp += str.charAt(i);
            }
            else{
                hm.put(temp, hm.getOrDefault(temp, 0) + 1);
                temp = "";
            }
        }
        
        hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        
        List<String> list = new ArrayList<>();
        
        for(String key: hm.keySet()){
            if(hm.get(key) == 1){
                list.add(key);
            }
        }
        
        String[] arr = new String[list.size()];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        
        return arr;
        
    }
    
}
