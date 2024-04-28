import java.util.*;

class Solution {

    long resultBaseNode = 0;

    int[] count;

    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        N = n;

        count = new int[n];

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];

        result[0] = (int) resultBaseNode;

        DFS(adj, 0, -1, result);

        return result;

    }

    private int dfsBase(Map<Integer, List<Integer>> adj, int currNode, int prevNode, int currDepth) {

        int totalNode = 1;

        resultBaseNode += currDepth;

        List<Integer> children = adj.getOrDefault(currNode, new ArrayList<>());

        for (int child : children) {
            if (child == prevNode)
                continue;

            totalNode += dfsBase(adj, child, currNode, currDepth + 1);
        }

        count[currNode] = totalNode;

        return totalNode;

    }

    private void DFS(Map<Integer, List<Integer>> adj, int parentNode, int prevNode, int[] result) {

        List<Integer> children = adj.getOrDefault(parentNode, new ArrayList<>());

        for (int child : children) {
            if (child == prevNode)
                continue;

            result[child] = result[parentNode] - count[child] + (N - count[child]);
            DFS(adj, child, parentNode, result);
        }

    }
    
}
