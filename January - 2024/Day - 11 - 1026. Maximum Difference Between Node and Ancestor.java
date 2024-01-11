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

    public static void helper(TreeNode node){

        if(node == null){
            return;
        }

        ca.add(node.val);

        if(node.left == null && node.right == null){
            ma.add(new ArrayList<>(ca));
        }

        helper(node.left);
        helper(node.right);
        ca.remove(ca.size()-1);

    }

    public static List<List<Integer>> ma;

    public static List<Integer> ca;

    public int maxAncestorDiff(TreeNode root) {
        
        ma = new ArrayList<>();

        ca = new ArrayList<>();

        helper(root);

        int max = 0;

        for(int i=0; i<ma.size(); i++){
            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;
            for(int j=0; j<ma.get(i).size(); j++){
                mini = Math.min(mini, ma.get(i).get(j));
                maxi = Math.max(maxi, ma.get(i).get(j));
            }
            max = Math.max(max, maxi-mini);
        }

        return max;

    }

}
