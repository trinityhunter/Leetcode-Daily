class Solution {

    public static int helper(String str, char ch){

        int i = 1;
        
        int count = 0;

        while(i<str.length()-1){

            char c = str.charAt(i);

            if(c==ch && ch==str.charAt(i+1) && str.charAt(i-1) == ch){
                count++;
            }

            i++;

        }

        return count;

    }

    public boolean winnerOfGame(String colors) {

        int a = helper(colors, 'A');

        int b = helper(colors, 'B');

        if(a>b){
            return true;
        }

        return false;

    }
    
}
