class Solution {

    public String shortestPalindrome(String s) {

        if(s.length() <= 1){
            return s;
        }

        int arr[] = new int[s.length()];
        
        int i = 1;
        
        int j = 0;
        
        int max = 0;

        char[] ch = s.toCharArray();

        arr[0] = 0;

        while(i<s.length()){

            if(ch[i] == ch[j]){
                j++; 
                arr[i] = j;
                i++;
            }
            else if(j!=0){
                j = arr[j-1];
            }
            else{
                arr[i++] = 0;
            }

        }

        StringBuilder sb = new StringBuilder(s); 
        
        sb.reverse();

        String yo = sb.toString();

        j = 0;
        
        i = 0;

        while(i<yo.length()){

            if(yo.charAt(i) == ch[j]){
                i++; 
                j++; 
            }
            else if(j!=0){
                j = arr[j-1]; 
            }
            else{
                i = i+1;
            }

        }

        StringBuilder jk = new StringBuilder(s.substring(j,s.length()));

        jk.reverse();
        
        jk.append(s);

        return jk.toString();

    }

}
