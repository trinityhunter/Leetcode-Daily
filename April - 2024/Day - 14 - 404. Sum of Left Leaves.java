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
        
        if(node.left!=null){
            if(node.left.left == null && node.left.right == null){
                ans += node.left.val;
                // return;
            }
        }
        
        helper(node.left);
        helper(node.right);

    }
    
    public static int ans;
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        ans = 0;
        
        helper(root);
        
        return ans;  

    }
    
}
