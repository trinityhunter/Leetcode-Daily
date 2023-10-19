class Solution {

    public static Stack<Character> helper(String s){

        Stack<Character> st=new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='#') {
                if(!st.empty()) {
                    st.pop();
                }
            }
            else{
                st.push(c);
            }
        }

        return st;

    }

    public boolean backspaceCompare(String s, String t) {

        return helper(s).equals(helper(t));

    }

}
