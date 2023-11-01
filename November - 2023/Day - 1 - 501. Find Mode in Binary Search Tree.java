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
    
    public static void fill(TreeNode node){

        if(node == null){
            return;
        }
        
        fill(node.left);
        
        if(ca.size()>0){
            if(ca.get(ca.size()-1) == node.val){
                ca.add(node.val);
            }
            else{
                ma.add(ca);
                max = Math.max(max, ca.size());
                ca = new ArrayList<>();
                ca.add(node.val);
            }
        }
        else{
            ca.add(node.val);
        }
        
        fill(node.right);

    }
        
    public static ArrayList<ArrayList<Integer>> ma = new ArrayList<>();

    public static ArrayList<Integer> ca = new ArrayList<>();
    
    public static int max;

    public int[] findMode(TreeNode root) {

        ma = new ArrayList<>();

        ca = new ArrayList<>();
        
        max = 0;

        fill(root);
        
        max = Math.max(max, ca.size());
        
        ma.add(ca);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<ma.size(); i++){
            if(ma.get(i).size() == max){
                ans.add(ma.get(i).get(0));
            }
        }

        int[] fin = new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++){
            fin[i] = ans.get(i);
        }
        
        return fin;
        
    }

}
