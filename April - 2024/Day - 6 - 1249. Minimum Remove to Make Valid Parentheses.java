class Solution {

    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();

        Set<Integer> toRemove = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')'){
                if (stack.isEmpty()){
                    toRemove.add(i);
                } 
                else{
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()){
            toRemove.add(stack.pop());
        }
        
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!toRemove.contains(i)){
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();

    }

}
