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

    public static long helper(TreeNode root, int k){

        if(root == null){
            return 0;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        while(q.size()>0){

            int count = q.size();
            
            long sum = 0;

            for(int i=0; i<count; i++){

                TreeNode rem = q.remove();

                sum += rem.val;

                if(rem.left!=null){
                    q.add(rem.left);
                }

                if(rem.right!=null){
                    q.add(rem.right);
                }

            }

            pq.add(sum);

        }

        while(pq.size()>0 && k>0){
            long ans = pq.remove();
            k--;
            if(k == 0){
                return ans;
            }
        }

        return -1;

    }

    public long kthLargestLevelSum(TreeNode root, int k) {

        long ans = helper(root, k);

        return ans;

    }

}
