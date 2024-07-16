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

    public static void helper(TreeNode root, int val, StringBuilder sb){
        
        if(root == null){
            return;
        }

        if(root.val == val){
            paths.add(sb.toString());
            return;
        }

        if(root.left != null){
            helper(root.left, val, sb.append("L"));
        }

        if(root.right != null){
            helper(root.right, val, sb.append("R"));
        }
        
        sb.deleteCharAt(sb.length() - 1);

        return;

    }

    public static TreeNode lca(TreeNode root, int a, int b){
        
        if(root == null){
            return null;
        }

        if(root.val == a || root.val == b){
            return root;
        }

        TreeNode left = lca(root.left, a, b);

        TreeNode right = lca(root.right, a, b);

        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else{
            return right;
        }

    }

    public static List<String> paths;

    public String getDirections(TreeNode root, int startValue, int destValue){

        if(root == null){
            return "";
        }

        paths = new ArrayList();

        TreeNode lca  = lca(root, startValue, destValue);

        helper(lca, startValue, new StringBuilder());

        helper(lca, destValue, new StringBuilder());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<paths.get(0).length(); i++){
            sb.append("U");
        }
        
        sb.append(paths.get(1));

        return sb.toString();

    }

}
