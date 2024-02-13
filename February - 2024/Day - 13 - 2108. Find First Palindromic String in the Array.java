class Solution {

    public boolean checkPalindrome(String s){

        int start = 0;

        int end = s.length()-1;

        while(start<=end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }

        return true;
        
    }

    public String firstPalindrome(String[] words) {

        for(String s: words){
            if(checkPalindrome(s)){
                return s;
            }
        }

        return "";    

    }

}
