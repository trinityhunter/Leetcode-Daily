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
    
    public static void levelOrder(TreeNode node) {

        Queue< TreeNode> mq = new ArrayDeque< >();

        mq.add(node);

        while (mq.size() > 0) {

            int count = mq.size();

            for (int i = 0; i < count; i++) {
                node = mq.remove();
                ca.add(node.val);
                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
            arr.add(ca);
            ca = new ArrayList<>();
        }
    }
    
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    
    public static ArrayList<Integer> ca = new ArrayList<>();
    
    public boolean isEvenOddTree(TreeNode root) {
        
        arr = new ArrayList<>();
        
        if(root.val%2==0){
            return false;
        }
        
        levelOrder(root);
        
        for(int i=0; i<arr.size(); i++){
            if(i%2==0){
                    if((arr.get(i).get(arr.get(i).size()-1)%2==0)){
                        return false;
                    }
                }
                
                if(i%2==1){
                   if((arr.get(i).get(arr.get(i).size()-1)%2==1)){
                        return false;
                    }     
                }
            for(int j=0; j<arr.get(i).size()-1; j++){
                if(i%2==0){
                    if(arr.get(i).get(j)%2==0){
                        return false;
                    }
                    if(arr.get(i).get(j)>=arr.get(i).get(j+1)){
                        return false;
                    }
                }
                else{
                    if(arr.get(i).get(j)%2==1){
                        return false;
                    }
                    if(arr.get(i).get(j)<=arr.get(i).get(j+1)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
