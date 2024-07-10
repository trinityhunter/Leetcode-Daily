class Solution {

    public int minOperations(String[] logs) {

        Stack<String> st = new Stack<String>();

        for(var log : logs){
            if(log.equals("../")){
                if(st.size()>0){
                    st.pop();
                }
            }
            else if(log.equals("./")){

            }
            else{
                st.push(log);
            }
        }

        return st.size();

    }
    
}
