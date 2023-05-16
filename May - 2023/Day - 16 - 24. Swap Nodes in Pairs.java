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

    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode s = head;
        
        ListNode f = head.next;
            
        while(f.next!=null && f.next.next!=null){
            int temp = s.val;
            s.val = f.val;
            f.val = temp;

            s = s.next.next;
            f = f.next.next;
        }
        
        int temp = s.val;
        s.val = f.val;
        f.val = temp;
        
        return head;
        
    }

}
