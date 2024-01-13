class Solution {

    public int minSteps(String s, String t) {
        
        int[] fs = new int[26];
        int[] ft = new int[26];
        
        for(int i=0; i<s.length(); i++){
            fs[s.charAt(i) - 'a']++;
            ft[t.charAt(i) - 'a']++;
        }
        
        int count = 0;
        
        for(int i=0; i<ft.length; i++){
            if(fs[i]>ft[i]){
                count += (fs[i] - ft[i]);
            }
        }
        
        return count;

    }

}
