/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void kLevelAway(TreeNode node, int k, TreeNode blocker){

        if(node == null || blocker == node){
            return;
        }

        if(k == 0){
            ans.add(node.val);
        }

        kLevelAway(node.left, k-1, blocker);
        kLevelAway(node.right, k-1, blocker);

    }

    public static List<TreeNode> nodeToRootPath(TreeNode root, TreeNode node){

        if(root == null || node == null){
            return new ArrayList<>();
        }

        if(root == node){
            List<TreeNode> arr = new ArrayList<>();
            arr.add(root);
            return arr;
        }

        List<TreeNode> left = nodeToRootPath(root.left, node);

        if(left.size()>0){
            left.add(root);
            return left;
        }

        List<TreeNode> right = nodeToRootPath(root.right, node);

        if(right.size()>0){
            right.add(root);
            return right;
        }

        return new ArrayList<>();

    }

    public static List<Integer> ans;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<TreeNode> arr = nodeToRootPath(root, target);

        ans = new ArrayList<>();

        for(int i=0; i<arr.size(); i++){
            if(i == 0){
                kLevelAway(arr.get(i), k-i, null);
            }
            else{
                kLevelAway(arr.get(i), k-i, arr.get(i-1));
            }
        }

        return ans;

    }

}
