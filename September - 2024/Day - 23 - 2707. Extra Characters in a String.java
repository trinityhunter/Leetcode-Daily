class Solution {

    public static boolean isAvailable(String word,String[] dic){

        for(String s: dic){

            if(s.equals(word)){
                return true;
            }

        }

        return false;

    }

    public static int helper(String s, String[] dic){

        if(s.length() == 0){
            return 0;
        }

        if(map.containsKey(s)){
            return map.get(s);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<s.length(); i++){

            String str = s.substring(0,i + 1);

            if(isAvailable(str, dic)){
                ans = Math.min(ans, helper(s.substring(i + 1), dic));
            }

        }

        ans = Math.min(ans, 1 + helper(s.substring(1), dic));

        map.put(s,ans);

        return ans;

    }

    public static Map<String,Integer> map;

    public int minExtraChar(String s, String[] dictionary) {

        map = new HashMap<>();

        return helper(s,dictionary);

    }

}
