class Solution {

    public int equalSubstring(String s, String t, int maxCost) {

        int l = 0;
        
        int cost = 0;
        
        int result = 0;

        for(int r=0; r<s.length(); r++){

            cost += Math.abs(s.charAt(r) - t.charAt(r));

            while(cost > maxCost){
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            result = Math.max(result, r-l+1);

        }

        return result;

    }
    
}
