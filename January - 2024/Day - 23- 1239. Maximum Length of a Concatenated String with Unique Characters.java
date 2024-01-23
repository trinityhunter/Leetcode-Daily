class Solution {

    public static boolean isValid(List<String> al, String str){

        HashMap<Character, Integer> hm1 = new HashMap<>();

        for(int i=0; i<al.size(); i++){
            for(int j=0; j<al.get(i).length(); j++){
                hm1.put(al.get(i).charAt(j), hm1.getOrDefault(al.get(i).charAt(j), 0) + 1);
                if(hm1.get(al.get(i).charAt(j)) > 1 ){
                    return false;
                }
            }
        }

        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            hm2.put(str.charAt(i), hm2.getOrDefault(str.charAt(i), 0) + 1);
            if(hm2.get(str.charAt(i)) > 1){
                return false;
            }
        }

        for(char key: hm2.keySet()){
            if(hm1.containsKey(key)){
                return false;
            }
        }

        return true;

    }

    public static void helper(List<String> arr, int ind){

        int sz = 0;

        for(int i=0; i<al.size(); i++){
            sz += al.get(i).length();
        }

        ans = Math.max(ans, sz);

        if(ind == arr.size()){
            return;
        }

        helper(arr, ind+1);

        if(isValid(al, arr.get(ind))){
            al.add(arr.get(ind));
            helper(arr, ind+1);
            al.remove(al.size()-1);
        }

    }

    public static List<String> al;

    public static int ans;

    public int maxLength(List<String> arr) {

        al = new ArrayList<>();

        ans = 0;
        
        helper(arr, 0);

        return ans;

    }

}
