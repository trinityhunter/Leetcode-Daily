class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st = new Stack<>();

        int i = 0;

        int j = 0;

        while(i<pushed.length && j<popped.length){

            while(pushed[i] != popped[j]){
                st.push(pushed[i]);
                i++;
            }

            st.push(pushed[i]);
            i++;

            st.pop();
            j++;

            while(st.size()>0 && st.peek() == popped[j]){
                st.pop();
                j++;
            }

        }

        if(st.size() == 0){
            return true;
        }

        return false;

    }

}
