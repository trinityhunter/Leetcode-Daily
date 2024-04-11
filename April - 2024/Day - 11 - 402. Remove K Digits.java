class Solution {

    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder();

        for(char digit: num.toCharArray()){
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)>digit){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }

            sb.append(digit);
        }

        while(k>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }

        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();

    }
    
}
