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

import java.math.BigInteger;

class Solution {
    
    public ListNode doubleIt(ListNode head) {
    
        ListNode temp = head;
        
        String str = "";
        
        while(temp!=null){
            str += temp.val;
            temp = temp.next;
        }
        
        BigInteger int1 = new BigInteger(str);
        
        BigInteger int2 = new BigInteger("2");
        
        BigInteger res = int1.multiply(int2);
        
        str = res.toString();
        
        // System.out.println(str);
        
        ListNode ans = new ListNode(0);
        
        ListNode anss = ans;
        
        int ind = 0;
        
        while(ind<str.length()){
            ans.next = new ListNode((int)(str.charAt(ind)-'0'));
            ans = ans.next;
            ind++;
        }
        
        return anss.next;
        
    }
    
}
