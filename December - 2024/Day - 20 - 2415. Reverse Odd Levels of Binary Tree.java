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

    public static void swap(List<TreeNode> ca){

        for(int i=0; i<ca.size()/2; i++){
            int temp = ca.get(i).val;
            ca.get(i).val = ca.get(ca.size()-1-i).val;
            ca.get(ca.size()-1-i).val = temp;
        }

    }

    public static void helper(TreeNode node){

        if(node == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);

        List<TreeNode> ca = new ArrayList<>();

        int level = 0;

        while(q.size()>0){

            int count = q.size();

            for(int i=0; i<count; i++){

                TreeNode rem = q.remove();

                ca.add(rem);

                if(rem.left!=null){
                    q.add(rem.left);
                }

                if(rem.right!=null){
                    q.add(rem.right);
                }

            }

            if(level%2 == 1){
                swap(ca);
            }

            level++;

            ca = new ArrayList<>();

        }

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        
        helper(root);

        return root;

    }

}
