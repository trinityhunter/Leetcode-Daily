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

    public ListNode swapNodes(ListNode head, int k) {
        
        k--;
        
        ListNode s = head;
        
        ListNode f = head;
        
        int count = 0;
        
        while(f!=null && count!=k){
            f = f.next;
            count++;
        }
        
        ListNode start = f;
        
        while(f.next!=null){
            s = s.next;
            f = f.next;
        }
        
        ListNode stop = s;
        
        int temp = start.val;
        start.val = stop.val;
        stop.val = temp;
        
        
        return head;
        
    }

}
