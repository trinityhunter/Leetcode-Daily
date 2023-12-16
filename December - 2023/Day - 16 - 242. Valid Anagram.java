class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        
        int[] arr1 = new int[s.length()];
        int[] arr2 = new int[t.length()];
        
        for(int i=0; i<s.length(); i++){
            arr1[i] = s.charAt(i) - 'a';
        }
        
        for(int i=0; i<t.length(); i++){
            arr2[i] = t.charAt(i) - 'a';
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for(int i=0; i<s.length(); i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        
        return true;
    }
}
