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

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        
        ListNode temp1 = list1;
        
        String str1 = "";
        
        while(temp1!=null){
            str1 += temp1.val + "";
            temp1 = temp1.next;
        }
        
        ListNode temp2 = list2;
        
        String str2 = "";
        
        while(temp2!=null){
            str2 += temp2.val + "";
            temp2 = temp2.next;
        }
        
        BigInteger b1=new BigInteger(str1);
        BigInteger b2=new BigInteger(str2);
        
        
        String str = b1.add(b2) + "";
        
        // System.out.println(str);
        
        ListNode ans = new ListNode();
        
        ListNode answ = ans;
        
        for(int i=0; i<str.length(); i++){
            ans.next = new ListNode(str.charAt(i)-'0');
            ans = ans.next;
        }
        
        return answ.next;
        
    }

}
