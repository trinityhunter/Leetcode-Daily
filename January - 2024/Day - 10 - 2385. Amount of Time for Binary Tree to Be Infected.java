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

    public static int kDistanceAway(TreeNode root,int k,TreeNode blocker){

        if(root == null || root == blocker){
            return k-1;
        }
        
        int left = kDistanceAway(root.left, k+1, blocker);
        
        int right = kDistanceAway(root.right, k+1, blocker);
        
        return Math.max(left, right);

    }

    public static List<TreeNode> nodeToRootPath(TreeNode node, int target){

        if(node == null){
            return new ArrayList<>();
        }

        if(node.val == target){
            List<TreeNode> arr = new ArrayList<>();
            arr.add(node);
            return arr;
        }

        List<TreeNode> left = nodeToRootPath(node.left, target);

        if(left.size()>0){
            left.add(node);
            return left;
        }

        List<TreeNode> right = nodeToRootPath(node.right, target);

        if(right.size()>0){
            right.add(node);
            return right;
        }

        return new ArrayList<>();

    }

    public int amountOfTime(TreeNode root, int start) {
        
        List<TreeNode> path = nodeToRootPath(root, start);

        int ans = 0;

        for(int i=0; i<path.size(); i++){
            int time = kDistanceAway(path.get(i), i, i==0?null:path.get(i-1));
            ans = Math.max(ans, time);
        }

        return ans;

    }

}
