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

    public static int helper(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = helper(root.left);

        int right = helper(root.right);

        ans = Math.max(ans, left+right);

        return Math.max(left, right) + 1;

    }

    public static int ans;

    public int diameterOfBinaryTree(TreeNode root) {

        ans = 0;

        helper(root);

        return ans;

    }

}
