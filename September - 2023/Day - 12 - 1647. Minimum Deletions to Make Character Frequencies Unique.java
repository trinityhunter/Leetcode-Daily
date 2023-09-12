class Solution {

    public int minDeletions(String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        int ans = 0;

        for(char key: hm.keySet()){
            if(!set.contains(hm.get(key))){
                set.add(hm.get(key));
            }
            else{
                int freq = hm.get(key);
                while(set.contains(freq) && freq != 0){
                    ans++;
                    freq--;
                }
                if(freq != 0){
                    set.add(freq);
                }
            }
        }

        return ans;

    }

}
