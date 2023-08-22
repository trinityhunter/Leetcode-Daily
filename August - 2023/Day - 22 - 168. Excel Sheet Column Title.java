class Solution {

    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();

        while(n>0){

            n--;

            int num = n%26;

            sb.insert(0, (char)((num)+'A'));

            n = n/26;

        }

        return sb.toString();

    }

}
