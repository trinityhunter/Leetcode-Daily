class Solution {

    public String removeDuplicateLetters(String s) {

        Set<Character> vis = new HashSet<>();

        int[] freq = new int[26];

        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }

        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){

            freq[ch - 'a']--;

            if(vis.contains(ch)){
                continue;
            }

            while(!st.isEmpty() && ch<st.peek() && freq[st.peek() - 'a'] > 0) {
                vis.remove(st.pop());
            }

            st.push(ch);

            vis.add(ch);

        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }

        return sb.toString();

    }

}
