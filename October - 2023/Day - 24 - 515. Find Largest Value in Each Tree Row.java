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
    
    public static void kLevel(TreeNode node, int k){
        if(node == null){
            return;
        }
        
        if(k == 0){
            max = Math.max(max, node.val);
        }
        
        kLevel(node.left, k-1);
        kLevel(node.right, k-1);
    }
    
    public static int max;
    
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> arr = new ArrayList<>();
        
        int h = height(root) - 1;
        
        for(int i=0; i<=h; i++){
            max = Integer.MIN_VALUE;
            kLevel(root, i);
            arr.add(max);
        }
        
        
        return arr;
        
    }

}
