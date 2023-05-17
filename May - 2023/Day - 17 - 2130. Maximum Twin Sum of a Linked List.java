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
    
    public static ListNode getMid(ListNode head){
        
        ListNode s = head;
        ListNode f = head;
        
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }
        
        return s;
        
    }
    
    public static ListNode getReverse(ListNode head){
        
        ListNode prev = null;
        
        ListNode curr = head;
        
        while(curr!=null){
            ListNode og = curr.next;
            curr.next = prev;
            prev = curr;
            curr = og;
        }
        
        return prev;
        
    }
    
    public int pairSum(ListNode head) {
        
        ListNode mid = getMid(head);
        
        ListNode rev = getReverse(mid);
        
        ListNode temp1 = head;
        
        ListNode temp2 = rev;
        
        int max = Integer.MIN_VALUE;
        
        while(temp2!=null){
            max = Math.max(max, temp1.val + temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return max;
        
    }

}
