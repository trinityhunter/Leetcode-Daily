import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]}); 
            }
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            char currChar = (char) ('a' + curr[0]);
            int count = Math.min(curr[1], repeatLimit);
            curr[1] -= count;

            for (int i = 0; i < count; i++) {
                result.append(currChar);
            }

            if (curr[1] > 0) {
                if (pq.isEmpty()) break;

                int[] next = pq.poll();
                char nextChar = (char) ('a' + next[0]);
                result.append(nextChar); 
                next[1]--;

                if (next[1] > 0) {
                    pq.offer(next);
                }
                pq.offer(curr);
            }
        }

        return result.toString();
    }
}
