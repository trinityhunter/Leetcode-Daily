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

    public static void helper(ListNode right, int count){

        if(right == null){
            return;
        }

        helper(right.next, count+1);

        if(count>size/2){
            ListNode og = left.next;

            left.next = right;

            right.next = og;

            left = og;
        }

        if(count == size/2){
            right.next = null;
        }


    }

    public static ListNode left;

    public static int size;

    public void reorderList(ListNode head) {

        size = 0;

        ListNode temp = head;

        while(temp!=null){
            size++;
            temp = temp.next;
        }

        ListNode right = head;

        left = head;

        helper(right, 0);

    }

}
