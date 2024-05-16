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

    public static boolean helper(TreeNode node){

        if(node.left == null && node.right == null){
            if(node.val == 1){
                return true;
            }
            return false;
        }

        if(node.val == 2){
            return helper(node.left) || helper(node.right);
        }
        else{
            return helper(node.left) && helper(node.right);
        }

    }

    public boolean evaluateTree(TreeNode root) {
        
        boolean ans = helper(root);

        return ans;

    }

}
