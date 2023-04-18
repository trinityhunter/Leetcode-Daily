class Solution {

    public String mergeAlternately(String word1, String word2) {

        int i = 0;

        int j = 0;

        int flag = 0;

        StringBuilder sb = new StringBuilder();

        while(i<word1.length() && j<word2.length()){

            if(flag == 0){
                sb.append(word1.charAt(i));
                i++;
                flag = 1;
            }
            else{
                sb.append(word2.charAt(j));
                j++;
                flag = 0;
            }

        }

        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }

        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }

        return sb.toString();

    }

}
