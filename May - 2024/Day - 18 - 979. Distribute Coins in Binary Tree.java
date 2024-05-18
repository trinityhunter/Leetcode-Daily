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

class Pair{

    int extra;
    int move;

    public Pair(int extra, int move){
        this.extra = extra;
        this.move = move;
    }

}

class Solution {

    public static Pair solve(TreeNode root){

        if(root == null){
            return new Pair(0, 0);
        }

        Pair left = solve(root.left);

        Pair right = solve(root.right);

        int extra = left.extra + right.extra + root.val - 1;

        int move = left.move + right.move + Math.abs(extra);

        return new Pair(extra, move);

    }

    public int distributeCoins(TreeNode root) {

        Pair ans = solve(root);

        return ans.move;

    }

}
