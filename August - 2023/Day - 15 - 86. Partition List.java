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

    public ListNode partition(ListNode head, int x) {

        ListNode first = new ListNode(0);

        ListNode second = new ListNode(0);

        ListNode temp = head;

        ListNode secondstart = second;

        ListNode ans = first;

        while(temp!=null){

            if(temp.val>=x){
                second.next = temp;
                second = second.next;
            }
            else{
                first.next = temp;
                first = first.next;
            }

            temp = temp.next;

        }

        first.next = null;

        second.next = null;

        first.next = secondstart.next;

        return ans.next;

    }

}
