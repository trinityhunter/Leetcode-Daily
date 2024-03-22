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
class Solution {

    // public static void helper(ListNode right){

    //     if(right == null){
    //         return;
    //     }

    //     helper(right.next);

    //     if(left.val!=right.val){
    //         ans = false;
    //     }

    //     left = left.next;

    // }

    // public static ListNode left;

    // public static boolean ans;

    public static ListNode getReverse(ListNode head){

        ListNode curr = head;

        ListNode prev = null;

        while(curr!=null){

            ListNode og = curr.next;

            curr.next = prev;

            prev = curr;

            curr = og;

        }

        return prev;

    }

    public static ListNode getMid(ListNode head){

        ListNode slow = head;

        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            slow = slow.next;

            fast = fast.next.next;

        }

        return slow;

    }

    public boolean isPalindrome(ListNode head) {

        // ***** Recursive Pointer ***** - 

        // left = head;

        // ans = true;

        // helper(head);

        // return ans;

        // ***** Iterative Pointer ***** - 

        ListNode second = getMid(head);

        ListNode rev = getReverse(second);

        while(rev!=null){
            if(rev.val!=head.val){
                return false;
            }
            rev = rev.next;
            head = head.next;
        }

        return true;

    }

}
