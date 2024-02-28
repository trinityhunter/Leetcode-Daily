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
    
    public static int height(TreeNode node){

        if(node == null){
            return 0;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        return Math.max(lh, rh) + 1;
        
    }
    
    public static void fill(TreeNode node, int k){

        if(node == null){
            return;
        }
        
        if(k == 0){
            arr.add(node.val);
        }
        
        
        fill(node.left, k-1);
        fill(node.right, k-1);

    }
    
    public static ArrayList<Integer> arr = new ArrayList<>();
    
    public int findBottomLeftValue(TreeNode root) {
        
        int h = height(root) - 1;
        
        arr = new ArrayList<>();
        
        fill(root, h);
        
        return arr.get(0);

    }

}
