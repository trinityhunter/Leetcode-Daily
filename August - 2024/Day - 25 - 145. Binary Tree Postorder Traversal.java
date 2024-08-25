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
        helper(node.right);
        
        arr.add(node.val);

    }

    public static List<Integer> arr;

    public List<Integer> postorderTraversal(TreeNode root) {
        
        arr = new ArrayList<>();

        helper(root);

        return arr;

    }

}
