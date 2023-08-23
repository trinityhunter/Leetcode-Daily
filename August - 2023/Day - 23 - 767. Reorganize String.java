public class Solution {

    public String reorganizeString(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for(char c: s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));

        pq.addAll(hm.keySet());

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2){

            char char1 = pq.remove();

            char char2 = pq.remove();

            sb.append(char1);

            sb.append(char2);

            hm.put(char1, hm.get(char1) - 1);

            hm.put(char2, hm.get(char2) - 1);

            if(hm.get(char1) > 0){
                pq.add(char1);
            }

            if(hm.get(char2) > 0){
                pq.add(char2);
            }

        }

        if(!pq.isEmpty()){

            char ch = pq.remove();

            if(hm.get(ch) > 1){
                return "";
            }

            sb.append(ch);

        }

        return sb.toString();

    }

}
