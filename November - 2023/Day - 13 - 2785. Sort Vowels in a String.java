class Solution {
    
    public static String permuteString(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] sArr = s.toCharArray();
        char[] vowelsArr = new char[sArr.length];
        char[] resultArr = new char[sArr.length];

        int vowelIndex = 0;
        for (char c : sArr) {
            if (isVowel(c)) {
                vowelsArr[vowelIndex] = c;
                vowelIndex++;
            }
        }

        Arrays.sort(vowelsArr, 0, vowelIndex);

        int vowelCounter = 0;
        
        for (int i = 0; i < sArr.length; i++) {
            if (isVowel(sArr[i])) {
                resultArr[i] = vowelsArr[vowelCounter];
                vowelCounter++;
            } else {
                resultArr[i] = sArr[i];
            }
        }

        return new String(resultArr);
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    
//     public static boolean isVowel(char ch){
        
//         if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
//             return true;
//         }
        
//         return false;
        
//     }
    
    public String sortVowels(String s) {
    
//         char[] arr = new char[s.length()];
        
//         int A=0, E=0, I=0, O=0, U=0, a=0, e=0, i=0, o=0, u = 0;
        
//         for(int ind=0; ind<s.length(); ind++){
//             if(!isVowel(s.charAt(ind))){
//                 arr[ind] = s.charAt(ind);
//             }
//             else{
//                 if(s.charAt(ind)-'A' == 0){
//                     A++;
//                 }
//                 if(s.charAt(ind)-'E' == 0){
//                     E++;
//                 }
//                 if(s.charAt(ind)-'I' == 0){
//                     I++;
//                 }
//                 if(s.charAt(ind)-'O' == 0){
//                     O++;
//                 }
//                 if(s.charAt(ind)-'U' == 0){
//                     U++;
//                 }
//                 if(s.charAt(ind)-'a' == 0){
//                     a++;
//                 }
//                 if(s.charAt(ind)-'e' == 0){
//                     e++;
//                 }
//                 if(s.charAt(ind)-'i' == 0){
//                     i++;
//                 }
//                 if(s.charAt(ind)-'o' == 0){
//                     o++;
//                 }
//                 if(s.charAt(ind)-'u' == 0){
//                     u++;
//                 }
//             }
//         }
        
//         int ind = 0;
        
//         StringBuilder sb = new StringBuilder();
        
//         while(ind<arr.length){
//             if(arr[ind] == (char) 0){
//                 while(A>0){
//                     arr[ind] = 'A';
//                     A--;
//                     break;
//                 }
//                 while(E>0){
//                     arr[ind] = 'E';
//                     E--;
//                     break;
//                 }
//                 while(I>0){
//                     arr[ind] = 'I';
//                     I--;
//                     break;
//                 }
//                 while(O>0){
//                     arr[ind] = 'O';
//                     O--;
//                     break;
//                 }
//                 while(U>0){
//                     arr[ind] = 'U';
//                     U--;break;
//                 }
//                 while(a>0){
//                     arr[ind] = 'a';
//                     a--;
//                     break;
//                 }
//                 while(e>0){
//                     arr[ind] = 'e';
//                     e--;
//                     break;
//                 }
//                 while(i>0){
//                     arr[ind] = 'i';
//                     i--;
//                     break;
//                 }
//                 while(o>0){
//                     arr[ind] = 'o';
//                     o--;
//                     break;
//                 }
//                 while(u>0){
//                     arr[ind] = 'u';
//                     u--;
//                     break;
//                 }
//             }
//             sb.append(arr[ind]);
//             ind++;
//         }
        
//         return sb.toString();
        
        return permuteString(s);
        
    }
    
}
