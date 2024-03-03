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

    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;

        node.next = node.next.next;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;

        ListNode fast = head;

        while(n>0){
            fast = fast.next;
            n--;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next!=null){
            deleteNode(slow);
            return head;
        }
        else{
            ListNode temp = head;

            ListNode ans = temp;

            if(temp.next == null){
                return null;
            }
            else if(temp.next.next == null){
                temp.next = null;
                return temp;
            }
            else{
                while(temp.next.next!=null){
                    temp = temp.next;
                }
                temp.next = null;
                return ans;
            }
        }

    }

}
