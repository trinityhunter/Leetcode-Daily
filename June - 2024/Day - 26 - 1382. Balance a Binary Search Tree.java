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

    public static TreeNode helper(int start, int end){

        if(start>end){
            return null;
        }

        int mid = (start+end)/2;

        TreeNode root = arr.get(mid);

        root.left = helper(start, mid-1);

        root.right = helper(mid+1, end);

        return root;

    }

    public static void fillUp(TreeNode node){

        if(node == null){
            return;
        }

        fillUp(node.left);
        arr.add(node);
        fillUp(node.right);

    }

    public static List<TreeNode> arr;

    public TreeNode balanceBST(TreeNode root) {

        arr = new ArrayList<>();

        fillUp(root);

        TreeNode ans = helper(0, arr.size()-1);

        return ans;
        
    }

}
