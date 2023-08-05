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

    public static List<TreeNode> helper(int start, int end){

        List<TreeNode> solution = new ArrayList<TreeNode>();

        if(start > end){
            solution.add(null);
            return solution;
        }

        for(int i = start; i<=end; i++){

            List<TreeNode> lefties = helper(start, i-1);

            List<TreeNode> righties = helper(i+1, end);

            for(TreeNode left: lefties){
                for(TreeNode right: righties){

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    solution.add(root);
                }
            }

        }
        
        return solution;
        
    }

    public List<TreeNode> generateTrees(int n) {
        
        if(n == 0){
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);

    }

}
