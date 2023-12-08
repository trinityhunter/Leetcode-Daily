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

    public static void printNode(TreeNode node, StringBuilder sb){

        if(node == null){
            return;
        }

        sb.append(node.val);

        if(node.left!=null || node.right!=null){
            sb.append("(");
            printNode(node.left, sb);
            sb.append(")");
        }

        if(node.right!=null){
            sb.append("(");
            printNode(node.right, sb);
            sb.append(")");
        }

    }

    public String tree2str(TreeNode root) {

        var sb = new StringBuilder();

        printNode(root, sb);

        return sb.toString();
        
    }

}
