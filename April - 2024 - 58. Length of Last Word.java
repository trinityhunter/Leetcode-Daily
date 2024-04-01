class Solution {

    public int lengthOfLastWord(String s) {

        s = s.trim();

        int n = s.length();
        
        int i = n - 1;

        for(i=n-1; i>=0;i--){
            if(s.charAt(i) == ' '){
                return n-i-1;
            }
        }

        return n;

    }

}
