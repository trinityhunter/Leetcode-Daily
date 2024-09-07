/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public static boolean helper(TreeNode root, ListNode head){

        if(root == null){
            return false;
        }

        if(root.val == head.val){

            if(head.next == null){
                return true;
            }

            return helper(root.left, head.next) || helper(root.right, head.next);

        }
        
        return false;
        
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        if(root == null && head == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(root.val == head.val){
            if(helper(root, head)){
                return true;
            }
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }

}
