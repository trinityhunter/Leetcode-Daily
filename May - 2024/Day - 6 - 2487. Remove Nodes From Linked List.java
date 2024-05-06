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

    public static int[] nextGreaterElement(List<Integer> nums){

        Stack<Integer> st = new Stack<>();

        int[] arr = new int[nums.size()];

        for(int i=nums.size()-1; i>=0; i--){

            if(st.size() == 0){
                arr[i] = -1;
            }
            else if(st.size()>0 && st.peek()>nums.get(i)){
                arr[i] = st.peek();
            }
            else if(st.size()>0 && st.peek()<=nums.get(i)){

                while(st.size()>0 && st.peek()<=nums.get(i)){
                    st.pop();
                }

                if(st.size() == 0){
                    arr[i] = -1;
                }
                else{
                    arr[i] = st.peek();
                }

            }

            st.push(nums.get(i));

        }

        return arr;

    }

    public ListNode removeNodes(ListNode head) {
        
        List<Integer> arr = new ArrayList<>();

        ListNode temp = head;

        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }

        int[] ngl = nextGreaterElement(arr);

        List<Integer> al = new ArrayList<>();

        for(int i=0; i<arr.size(); i++){
            if(ngl[i] == -1){
                al.add(arr.get(i));
            }
        }

        // System.out.println(al);

        ListNode res = new ListNode(0);

        ListNode ans = res;

        for(int i=0; i<al.size(); i++){
            res.next = new ListNode(al.get(i));
            res = res.next;
        }

        return ans.next;

    }

}
