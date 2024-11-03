class Solution {

    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){
            return false;
        }

        if(s.equals(goal)){
            return true;
        }
        
        return (s+s).contains(goal);

    }
    
}
