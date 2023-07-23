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

    public static List<TreeNode> helper(int n, Map<Integer, List<TreeNode>> dp){

        if(n == 0){
            return null;
        }
        
        if(dp.containsKey(n)){
            return dp.get(n);
        }

        List<TreeNode> list = new ArrayList<>();
        
        int leftSize = 1;

        int rightSize = n-leftSize-1; 

        while(rightSize > 0){

            List<TreeNode> leftTrees = helper(leftSize, dp);

            List<TreeNode> rightTrees = helper(rightSize, dp);
            
            for(TreeNode left: leftTrees){
                for(TreeNode right: rightTrees){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }

            leftSize += 2;

            rightSize -= 2;

        }
        
        dp.put(n, list);
        
        return list;

    }
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        if(n == 0){
            return null;
        }

        List<TreeNode> list = new ArrayList<>();
        
        if(n%2 == 0){
            return list;
        }

        list.add(new TreeNode(0));
        
        HashMap<Integer, List<TreeNode>> dp = new HashMap<>();

        dp.put(1, list);

        return helper(n, dp);
                
    }

}
