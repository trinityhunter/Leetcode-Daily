public class Solution {

    public static boolean isPalindrome(String str, int left, int right){

        if(left == right){
            return true;
        }

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    public static void helper(String s, int l){

        if(ca.size()>0 && l>=s.length()){
            List<String> r = (ArrayList<String>) ca.clone();
            ma.add(r);
        }

        for(int i=l; i<s.length(); i++){

            if(isPalindrome(s, l, i)){
                if(l == i){
                    ca.add(Character.toString(s.charAt(i)));
                }
                else{
                    ca.add(s.substring(l, i+1));
                }  
                helper(s, i+1);
                ca.remove(ca.size()-1);
            }
            
        }

    }

    public static List<List<String>> ma;

    public static ArrayList<String> ca;

    public List<List<String>> partition(String s) {

        ma = new ArrayList<List<String>>();

        ca = new ArrayList<String>();

        helper(s, 0);

        return ma;

    }

}
