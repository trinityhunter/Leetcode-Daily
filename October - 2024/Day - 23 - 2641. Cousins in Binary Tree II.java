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

    public TreeNode replaceValueInTree(TreeNode root) {

        if(root == null){
            return null;
        }

        Queue<TreeNode > q = new LinkedList<>();

        q.add(root);

        ArrayList<Integer> levellist=new ArrayList<>();
        
        while(!q.isEmpty()){

            int size = q.size();

            int sum = 0;

            for(int i=0; i<size; i++){

                TreeNode temp = q.poll();

                sum += temp.val;

                if(temp.left!=null){
                    q.add(temp.left);
                }

                if(temp.right !=null){
                    q.add(temp.right);
                }

            }
            
            levellist.add(sum);

        }

        int ind = 1;

        q.add(root);

        root.val = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i =0; i<size; i++){

                TreeNode temp = q.poll();

                int sibsum = ( (temp.left!=null)? temp.left.val:0 ) + ( (temp.right!=null)? temp.right.val:0);

                if(temp.left!=null){
                    temp.left.val = levellist.get(ind) - sibsum;
                    q.add(temp.left);
                }

                if(temp.right!=null){
                    temp.right.val = levellist.get(ind) - sibsum;
                    q.add(temp.right);
                } 

            }
            
            ind++;

        }

        return root;

    }
    
}
