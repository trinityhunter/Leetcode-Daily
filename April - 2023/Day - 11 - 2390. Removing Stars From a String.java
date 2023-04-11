class Solution {

    public String removeStars(String l) {
        
        Stack<Character> s = new Stack<>();
        
        for(char c : l.toCharArray()){
            if(c == '*'){
                s.pop();
            }
            else{
                s.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : s){
            sb.append(c);
        }
        
        return sb.toString();

    }

}
