class Solution {

    public String makeGood(String s) {

        Stack<Character> sGood = new Stack();

        for(char c : s.toCharArray()){
            if(!sGood.isEmpty() && Math.abs(sGood.peek() - c) == 32){
                sGood.pop();
            }
            else{
                sGood.push(c);
            }
        }

        StringBuilder st = new StringBuilder();

        while(!sGood.isEmpty()){
            st.append(sGood.pop());
        }

        return st.reverse().toString();

    }
    
}
