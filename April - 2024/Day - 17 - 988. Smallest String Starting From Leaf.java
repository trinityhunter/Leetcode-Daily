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

    public static void solve(TreeNode root, StringBuilder s){
        
        if(root == null){
            return;
        }
           
        s.append((char)('a'+root.val)+"");

        if(root.left==null && root.right==null){
            str.add(s.reverse());  
            return ;
        }

        solve(root.left,new StringBuilder(s));

        solve(root.right,new StringBuilder(s));

        return;

    }

    public static List<StringBuilder> str;

    public String smallestFromLeaf(TreeNode root) {

        str = new ArrayList();

        solve(root,new StringBuilder(""));

        Collections.sort(str);

        return str.get(0).toString();
        
    }

}
