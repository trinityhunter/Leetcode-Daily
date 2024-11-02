class Solution {

    public boolean isCircularSentence(String sentence) {

        Deque<Character> st = new ArrayDeque<>();

        if(sentence.charAt(0) != sentence.charAt(sentence.length() - 1)){
            return false;
        }
        
        String[] strs = sentence.split(" ");

        for(String str: strs){

            int n = str.length();

            if(st.isEmpty()){

                st.push(str.charAt(0));

                st.push(str.charAt(n - 1));

            } 
            else{

                char c = str.charAt(0);

                if(c == st.peek()){

                    st.pop();

                    st.push(str.charAt(n - 1));

                } 
                else{
                    return false;
                }

            }

        }

        return true;

    }
    
}
