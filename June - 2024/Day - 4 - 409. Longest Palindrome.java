class Solution {

    public int longestPalindrome(String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int ans = 0;
        
        int odd = 0;
        
        for(char key: hm.keySet()){
            if(hm.get(key)%2==0){
                ans += hm.get(key);
            }
            else{
                ans += hm.get(key) - 1;
                odd++;
            }
        }
        
        if(odd>0){
            ans++;
        }
        
        return ans;
        
    }
    
}
