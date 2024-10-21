class Solution {

    private int backtrack(String s, int start, Set<String> seen){

        if(start == s.length()){
            return 0;
        }
        
        int maxSplits = 0;

        for(int end = start + 1; end <= s.length(); end++){

            String substring = s.substring(start, end);

            if(!seen.contains(substring)){

                seen.add(substring);
                
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, end, seen));
                
                seen.remove(substring);

            }

        }

        return maxSplits;

    }

    public int maxUniqueSplit(String s) {
        
        return backtrack(s, 0, new HashSet<>());

    }
    
}
