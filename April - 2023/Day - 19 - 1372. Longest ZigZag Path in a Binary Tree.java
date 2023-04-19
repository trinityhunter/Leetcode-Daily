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

    public static int helper(TreeNode node, int GMax, int max, int fromLeft, int fromRight){

        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return max;
        }

        int lm = Integer.MIN_VALUE;

        if(node.left != null){

            if(fromLeft == 1){
                max = Math.max(max, 1);

                lm = helper(node.left, 1, max, 1, 0);
            } 
            else{
                max = Math.max(max, GMax + 1);

                lm = helper(node.left, GMax + 1, max, 1, 0);
            }

        }

        int rm = Integer.MIN_VALUE;

        if(node.right != null){

            if(fromRight == 1){
                max = Math.max(max, 1);

                rm = helper(node.right, 1, max, 0, 1);
            } 
            else{
                max = Math.max(max, GMax + 1);

                rm = helper(node.right, GMax + 1, max, 0, 1);
            }

        }
        
        return Math.max(lm, rm);

    }

    public int longestZigZag(TreeNode root) {

        return helper(root, 0, 0, 1, 1);

    }
    
}
