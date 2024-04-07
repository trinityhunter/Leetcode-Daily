class Solution {

    public boolean checkValidString(String s1) {

        Stack<Integer> b = new Stack<>();

        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<s1.length(); i++){

            if(s1.charAt(i) == '('){
                b.push(i);
            }
            else if(s1.charAt(i) == '*'){
                s.push(i);
            }
            else if(!b.isEmpty()){
                b.pop();
            }
            else if(!s.isEmpty()){
                s.pop();
            }
            else{
                return false;
            }

        }


        while(!b.isEmpty() && !s.isEmpty() && b.peek() < s.peek()){
            b.pop();
            s.pop();
        }

        if(b.isEmpty()){
            return true;
        }

        return false;

    }
    
}
