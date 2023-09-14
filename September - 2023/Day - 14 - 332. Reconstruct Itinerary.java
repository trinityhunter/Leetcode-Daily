class Solution {

    public static void helper(String s, Map<String, PriorityQueue<String>> map, LinkedList<String> list){

        PriorityQueue<String> pq = map.get(s);

        while(pq != null && !pq.isEmpty()){
            helper(pq.poll(), map, list);
        }

        list.addFirst(s);

    }

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> li: tickets){

            String s1 = li.get(0);

            String s2 = li.get(1);

            if(!map.containsKey(s1)){
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(s1,pq);
            }

            map.get(s1).add(s2);

        }

        LinkedList<String> list = new LinkedList<>();

        helper("JFK", map, list);

        return list;

    }

}
