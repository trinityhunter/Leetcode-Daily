class Solution {

    public int maximumGain(String s, int x, int y) {

        Stack<Character>stack = new Stack<>();

        int ans = 0;

        if(x>y){

            for(char ch: s.toCharArray()){
                if(!stack.isEmpty() && (stack.peek() == 'a' && ch == 'b')){
                    ans += x;
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }

            StringBuilder sb = new StringBuilder();

            while(!stack.isEmpty()) sb.insert(0,stack.pop());

            for(char ch:sb.toString().toCharArray()){

                if(!stack.isEmpty() && (stack.peek() == 'b' && ch == 'a')){
                    ans += y;
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }

            }

            return ans;

        }
        else{
            
            for(char ch:s.toCharArray()){
                if(!stack.isEmpty() && (stack.peek() == 'b' && ch == 'a')){
                    ans += y;
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }

            StringBuilder sb = new StringBuilder();

            while(!stack.isEmpty()) sb.insert(0,stack.pop());

            for(char ch:sb.toString().toCharArray()){
                if(!stack.isEmpty() && (stack.peek() == 'a' && ch == 'b')){
                    ans += x;
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }

            return ans;

        }

    }

}
