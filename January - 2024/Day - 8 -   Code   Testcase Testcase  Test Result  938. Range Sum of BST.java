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
    
    public static void helper(TreeNode node, int low, int high){
        
        if(node == null){
            return;
        }
        
        if(low <= node.val && node.val <= high){
            ans += node.val;
        }
        
        helper(node.left, low, high);
        helper(node.right, low, high);
        
    }
    
    public static int ans;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        ans = 0;
        
        helper(root, low, high);
        
        return ans;
        
    }
}
