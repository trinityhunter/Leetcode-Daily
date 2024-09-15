class Solution {

    public int findTheLongestSubstring(String s) {

        HashMap<Character, Integer> h = new HashMap<>();

        h.put('a', 0);

        h.put('e', 1);

        h.put('i', 2);

        h.put('o', 3);

        h.put('u', 4);

        int x = 0;

        HashMap<Integer, Integer> h2 = new HashMap<>();

        int res = 0;

        for(int i=0; i<s.length(); i++){

            if(h.containsKey(s.charAt(i))){
                x = x^(1<<h.get(s.charAt(i)));
            }

            if(!h2.containsKey(x)){
                h2.put(x, i);
            }
            else{
                res = Math.max(res, i - h2.get(x));
            }

            if(x == 0){
                res=i+1;
            }

        }

        return res;

    }
    
}
