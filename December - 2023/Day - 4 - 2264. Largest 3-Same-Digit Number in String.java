class Solution {

    public String largestGoodInteger(String num) {

        int x = 9;

        while(x>=0){
            if(num.contains("" + x + x + x)){
                return ("" + x + x + x);
            }
            x--;
        }

        return "";

    }
    
}
