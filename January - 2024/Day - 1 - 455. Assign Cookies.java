class Solution {

    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        
        Arrays.sort(s);
        
        int count = 0;

        int i=0;
        
        int j=0;
        
        while(j<s.length && i<g.length){
            if(s[j]>=g[i]){
                i++;
                count++;
            }
            j++;
        }

        return count;
        
    }

}
