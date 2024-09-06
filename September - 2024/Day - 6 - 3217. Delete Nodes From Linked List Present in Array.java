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

    public ListNode modifiedList(int[] nums, ListNode head) {

        int max = 0;
        
        for(int i=0; i<nums.length; i++){
            max = nums[i] > max ? nums[i] : max;
        }

        boolean[] arr = new boolean[max + 1];

        for(int i=0; i<nums.length; i++){
            arr[nums[i]] = true;
        }

        while(head != null && head.val <= max && arr[head.val]){
            head = head.next;
        }

        ListNode cur = head.next;

        ListNode prev = head;
        
        while(cur != null){
            
            if(cur.val <= max && arr[cur.val]){
                prev.next = cur.next;
            }
            else{
                prev = cur;
            }
            
            cur = cur.next;

        }

        return head;

    }
    
}
