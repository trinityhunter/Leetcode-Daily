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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode temp = list1;
        
        while(temp.val!=b+1){
            temp = temp.next;
        }
        
        
        ListNode temp1 = list1;
        
        int count = 0;
        
        while(temp1.next!=null){
            if(count == a-1){
                temp1.next = list2;
            }
            count++;
            temp1 = temp1.next;
        }
        
        temp1.next = temp;
        
        return list1;
        
    }
    
}
