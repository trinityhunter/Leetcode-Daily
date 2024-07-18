/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {

    int result = 0;

    private int[] dfs(TreeNode node, int distance) {

        if(node == null){
            return new int[distance + 1];
        }

        int[] map = new int[distance + 1];

        if(node.left == null && node.right == null){
            map[1] = 1;
            return map;
        }

        int[] left = dfs(node.left, distance);

        int[] right = dfs(node.right, distance);

        for(int i=1; i<=distance; i++){
            for(int j=1; j<=distance-i; j++){
                result += left[i] * right[j];
            }
        }

        for(int i=distance; i>0; i--){
            map[i] = (i > 1 ? left[i - 1] : 0) + (i > 1 ? right[i - 1] : 0);
        }

        return map;

    }

    public int countPairs(TreeNode root, int distance) {

        result = 0;

        dfs(root, distance);

        return result;
        
    }

}
