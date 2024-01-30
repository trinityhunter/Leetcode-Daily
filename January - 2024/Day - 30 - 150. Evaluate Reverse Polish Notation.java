class Solution {

    public static int operate(int op1, int op2, String str){

        if(str.equals("*")){
            return op1 * op2;
        }
        else if(str.equals("+")){
            return op1 + op2;
        }
        else if(str.equals("-")){
            return op1 - op2;
        }
        else{
            return op1 / op2;
        }
        
    }

    public static boolean ifOperand(String str){

        if(str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/")){
            return true;
        }
        else{
            return false;
        }

    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(String str : tokens){
            if(ifOperand(str)){
                int op2 = st.pop();
                int op1 = st.pop();
                int res = operate(op1, op2, str);
                st.push(res);
            }
            else{
                st.push(Integer.parseInt(str));
            }
        }

        return st.pop();

    }

}
