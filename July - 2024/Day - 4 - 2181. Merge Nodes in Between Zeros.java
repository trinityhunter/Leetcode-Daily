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

    public ListNode mergeNodes(ListNode head) {
        
        ListNode temp = head;

        temp = temp.next;
        
        ListNode zeros = head;
        
        ListNode ans = head;
        
        int count = 0;
        
        while(temp!=null){
            if(temp.val == 0){
                temp.val = count;
                zeros.next = temp;
                zeros = zeros.next;
                count = 0;
            }
            else{
                count += temp.val;
            }
            temp = temp.next;
        }
        
        return ans.next;
        
    }
    
}
