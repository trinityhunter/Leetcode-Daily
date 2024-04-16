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

    public static void helper(TreeNode root, int val, int depth){

        if(root == null){
            return;
        }

        if(depth == 2){

            TreeNode left = root.left;

            TreeNode right = root.right;

            root.left = new TreeNode(val);

            root.right = new TreeNode(val);

            root.left.left = left;

            root.right.right = right;

            return;

        }

        helper(root.left, val, depth-1);
        helper(root.right, val, depth-1);

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        helper(root, val, depth);

        return root;

    }

}
