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

    public static TreeNode helper(TreeNode root, HashSet<Integer> set){

        if(root == null){
            return null;
        }

        root.left = helper(root.left, set);

        root.right = helper(root.right, set);

        if(set.contains(root.val)){

            if(root.left!=null){
                arr.add(root.left);
            }

            if(root.right!=null){
                arr.add(root.right);
            }

            return null;

        }

        return root;

    }

    public static List<TreeNode> arr;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<to_delete.length; i++){
            set.add(to_delete[i]);
        }

        arr = new ArrayList<>();

        TreeNode node = helper(root, set);

        if(node!=null){
            arr.add(node);
        }

        return arr;

    }

}
