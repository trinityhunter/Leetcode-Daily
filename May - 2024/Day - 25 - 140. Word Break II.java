class Solution {

    public static List<String> helper(String s, HashSet<String> set){

        if(hm.containsKey(s)){
            return hm.get(s);
        }

        List<String> arr = new ArrayList<>();

        if(set.contains(s)){
            arr.add(s);
        }

        for(int i=1; i<=s.length(); i++){
            String left = s.substring(0, i);
            if(set.contains(left)){
                List<String> right = helper(s.substring(i), set);
                for(int j=0; j<right.size(); j++){
                    arr.add(left + " " + right.get(j));
                }
            }
        }

        hm.put(s, arr);

        return arr;

    }

    public static HashMap<String, List<String>> hm;

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        hm = new HashMap<>();
        
        List<String> ans = helper(s, set);

        return ans;

    }

}
