class Solution {

    public boolean buddyStrings(String A, String B) {

        if(A.length() != B.length()){
            return false;
        } 
        
        if(A.equals(B)){

            Set<Character> s = new HashSet<Character>();

            for(char c: A.toCharArray()){
                s.add(c);
            } 

            return s.size() < A.length();

        }
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<A.length(); i++){

            if(A.charAt(i) != B.charAt(i)){
                arr.add(i);
            }

        } 
        
        if(arr.size() == 2 && A.charAt(arr.get(0)) == B.charAt(arr.get(1)) && A.charAt(arr.get(1)) == B.charAt(arr.get(0))){
            return true;
        }
        
        return false;

    }
    
}
