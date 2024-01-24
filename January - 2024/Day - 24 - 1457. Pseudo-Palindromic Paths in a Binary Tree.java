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

    public static void helper(TreeNode node){

        if(node == null){
            return;
        }

        hm.put(node.val, hm.getOrDefault(node.val, 0) + 1);

        if(node.left == null && node.right == null){
            int count = 0;

            for(int key: hm.keySet()){
                if(hm.get(key)%2 == 1){
                    count++;
                }
            }

            if(count == 1 || count == 0){
                ans++;
            }
        }

        helper(node.left);
        helper(node.right);
        if(hm.get(node.val) == 1){
            hm.remove(node.val);
        }
        else{
            hm.put(node.val, hm.get(node.val)-1);
        }

    }

    public static HashMap<Integer, Integer> hm;

    public static int ans;

    public int pseudoPalindromicPaths (TreeNode root) {

        hm = new HashMap<>();

        ans = 0;

        helper(root);

        return ans;

    }

}
