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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        if(head.next.next == null){
            return new int[]{-1, -1};
        }
        
        ListNode temp = head;
        
        List<Integer> index = new ArrayList<>();

        int ind = 1;
        
        while(temp.next!=null && temp.next.next!=null){
            if(temp.val<temp.next.val && temp.next.next.val<temp.next.val){
                index.add(ind+1);
            }
            else if(temp.val>temp.next.val && temp.next.next.val>temp.next.val){
                index.add(ind+1);
            }
            ind++;
            temp = temp.next;
        }
        
        if(index.size()<2){
            return new int[]{-1, -1};
        }
        
        int min = Integer.MAX_VALUE;
        
        
        for(int i=0; i<index.size()-1; i++){
            min = Math.min(min, index.get(i+1) - index.get(i));
        }
        
        return new int[]{min, index.get(index.size()-1) - index.get(0)};
        
    }
    
}
