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

        helper(node.right);
        int temp = node.val;
        node.val += sum;
        sum += temp;
        helper(node.left);

    }

    public static int sum;

    public TreeNode bstToGst(TreeNode root) {

        sum = 0;
        
        helper(root);

        return root;

    }

}
