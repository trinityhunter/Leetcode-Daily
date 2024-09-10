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
    
    public static int gcd(int a, int b){
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
    
        ListNode ans = new ListNode(head.val);
        
        ListNode lk = ans;
        
        ListNode temp = head;
        
        int a = head.val;
        
        temp = temp.next;
        
        // int b = temp.val;
        
        while(temp!=null){
            int b = temp.val;
            ans.next = new ListNode(gcd(a, b));
            ans = ans.next;
            a = b;
            ans.next = new ListNode(temp.val);
            ans = ans.next;
            temp = temp.next;
        }
        
        return lk;
        
    }
    
}
