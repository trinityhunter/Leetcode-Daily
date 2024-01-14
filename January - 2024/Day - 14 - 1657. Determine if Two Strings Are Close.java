class Solution {

    public boolean closeStrings(String word1, String word2) {

        if(word1.length() != word2.length()){
            return false;
        }

        HashMap<Character, Integer> hm1 = new HashMap<>();

        HashMap<Character, Integer> hm2 = new HashMap<>();

        HashSet<Character> set1 = new HashSet<>();

        HashSet<Character> set2 = new HashSet<>();

        for(char ch: word1.toCharArray()){
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
            set1.add(ch);
        }

        for(char ch: word2.toCharArray()){
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
            set2.add(ch);
        }

        List<Integer> freq1 = new ArrayList<>(hm1.values());

        List<Integer> freq2 = new ArrayList<>(hm2.values());

        Collections.sort(freq1);

        Collections.sort(freq2);

        return set1.equals(set2) && freq1.equals(freq2);

    }

}
