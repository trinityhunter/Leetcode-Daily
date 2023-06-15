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
    
    public static void sumAtLevel(TreeNode node, int k){

        if(node == null){
            return;
        }
        
        if(k == 0){
            ans += node.val;
        }
        
        sumAtLevel(node.left, k-1);
        sumAtLevel(node.right, k-1);

    }
    
    public static ArrayList<Integer> arr = new ArrayList<>();
    
    public static int ans;
    
    public int maxLevelSum(TreeNode root) {
        
        arr = new ArrayList<>();
        
        int height = height(root) - 1;
        
        int max = Integer.MIN_VALUE;
        
        int maxLevel = 1;
        
        for(int i=0; i<=height; i++){
            ans = 0;
            sumAtLevel(root, i);
            if(max<ans){
                max = ans;
                maxLevel = i;
            }
        }
        
        return maxLevel + 1;

    }

}
