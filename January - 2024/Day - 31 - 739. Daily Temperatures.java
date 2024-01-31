
class Pair{

    int val;
    int ind;

    Pair(int val, int ind){
        this.val = val;
        this.ind = ind;
    }

}

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Pair> st = new Stack<>();

        int[] arr = new int[temperatures.length];

        for(int i=arr.length-1; i>=0; i--){

            if(st.size() == 0){
                arr[i] = 0;
            }
            else if(st.size()>0 && st.peek().val>temperatures[i]){
                arr[i] = st.peek().ind - i;
            }
            else if(st.size()>0 && st.peek().val<=temperatures[i]){

                while(st.size()>0 && st.peek().val<=temperatures[i]){
                    st.pop();
                }

                if(st.size() == 0){
                    arr[i] = 0;
                }
                else{
                    arr[i] = st.peek().ind - i;
                }

            }

            st.push(new Pair(temperatures[i], i));

        }

        return arr;

    }

}
