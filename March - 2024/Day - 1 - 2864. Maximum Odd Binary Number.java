class Solution {

    public String maximumOddBinaryNumber(String s) {

        int n = s.length();

        int count = 0;

        for(char c : s.toCharArray()){
            if(c == '1'){
                count++;
            }
        }

        StringBuilder st = new StringBuilder();

        for(int i=0; i<count-1; i++){
            st.append(1);
        }

        for(int i=0; i<n-count; i++){
            st.append(0);
        }

        st.append(1);

        return st.toString();

    }

}
