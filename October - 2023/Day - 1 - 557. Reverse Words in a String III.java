class Solution {

    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();

        int n = s.length();

        int i = 0;

        int st = 0;

        while(i<n){

            char ch = s.charAt(i);
            
            if(ch == ' ') {
                sb.append(' ');
                st = sb.length();
            }
            else{
               sb.insert( st , ch);
            }

            i++;

        }

        return sb.toString();
    }

}
