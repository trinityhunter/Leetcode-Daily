class Solution {

    public boolean makeEqual(String[] words) {

        HashMap<Character, Integer> map = new HashMap<>();

        int n = words.length; 

        for(String word: words){
            for(char c: word.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for(int count: map.values()){
            if(count % n!=0){
                return false;
            }
        }

        return true;

    }
    
}
