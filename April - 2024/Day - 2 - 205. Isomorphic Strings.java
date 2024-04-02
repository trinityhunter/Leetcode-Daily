class Solution {

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> hash = new HashMap<>();

        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);

            if(hash.containsKey(first)){
                if(hash.get(first)!=second){
                    return false;
                }
            } 
            else{
                if(set.contains(second)){
                    return false;
                } 
                else{
                    hash.put(first,second);
                    set.add(second);
                }
            }
        }

        return true;

    }
    
}
