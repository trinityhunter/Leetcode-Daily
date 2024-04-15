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

    public static void helper(TreeNode node, String psf){

        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            arr.add(psf+node.val);
            return;
        }

        helper(node.left, psf+node.val);
        helper(node.right, psf+node.val);

    }

    public static List<String> arr;

    public int sumNumbers(TreeNode root) {
        
        arr = new ArrayList<>();

        helper(root, "");

        int ans = 0;

        for(int i=0; i<arr.size(); i++){
            ans += Integer.parseInt(arr.get(i));
        }

        return ans;

    }

}
