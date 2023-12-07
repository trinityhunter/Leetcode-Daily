class Solution {

    public String largestOddNumber(String num) {

        int n = num.length() - 1;

        while(n >= 0){
            if((num.charAt(n) - '0') % 2 == 1)
                return num.substring(0, n + 1);
            n--;
        }

        return "";

    }
    
}
