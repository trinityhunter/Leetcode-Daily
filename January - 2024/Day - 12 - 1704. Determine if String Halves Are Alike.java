class Solution {

    public static boolean isVowel(char ch){
        
        char [] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        for(int i=0; i<arr.length; i++){
            if(ch == arr[i]){
                return true;
            }
        }
        
        return false;
            
    }
    
    public boolean halvesAreAlike(String s) {
        
        String a = s.substring(0, s.length()/2);
        String b = s.substring(s.length()/2, s.length());
        
        int one = 0;
        int two = 0;
        
        for(int i=0; i<a.length(); i++){
            if(isVowel(a.charAt(i))){
                one++;
            }
            if(isVowel(b.charAt(i))){
                two++;
            }
        }
        
        if(one == two){
            return true;
        }
        
        return false;
    }
    
}
