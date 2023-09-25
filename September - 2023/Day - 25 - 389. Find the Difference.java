class Solution {

    public char findTheDifference(String s, String t) {
        
        int[] arr1 = new int[s.length()];

        int[] arr2 = new int[t.length()];
        
        for(int i=0; i<s.length(); i++){
            arr1[i] = s.charAt(i) - 'a';
        }
        
        for(int i=0; i<t.length(); i++){
            arr2[i] = t.charAt(i) - 'a';
        }
        
        Arrays.sort(arr1);

        Arrays.sort(arr2);
        
        for(int i=0; i<s.length(); i++){
            if(arr1[i]!=arr2[i]){
                return (char) (arr2[i] + 97);
            }
        }
        
        return (char) (arr2[arr2.length-1] + 97);

    }
    
}
