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
    
    public static void fillOne(TreeNode node){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            str1 += node.val + ",";
        }
        
        fillOne(node.left);
        fillOne(node.right);
    }
    
    public static void fillTwo(TreeNode node){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            str2 += node.val + ",";
        }
        
        fillTwo(node.left);
        fillTwo(node.right);
    }
    
    public static String str1;
    public static String str2;
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        str1 = "";
        str2 = "";
        
        fillOne(root1);
        fillTwo(root2);
        
        if(str1.length()!=str2.length()){
            return false;
        }
        
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}
