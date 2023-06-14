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
        
        helper(node.left);

        if(prev != null){
            min = Math.min(Math.abs(node.val - prev.val), min);
        }

        prev = node;
        
        helper(node.right);
        
    }
    
    public static int min;
    
    public static TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        
        min = Integer.MAX_VALUE;
        
        prev = null;
        
        helper(root);
        
        return min;
        
    }

}
