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
    
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        ListNode temp = head;
        
        ArrayList<Integer> al = new ArrayList<>();
        int ind = 0;
                
        while(temp!=null){
            al.add(temp.val);
            temp = temp.next;
        }
        
        int sz = m*n-al.size();
        
        // System.out.println(sz);
        
        for(int i=0; i<sz; i++){
            al.add(-1);
        }
        
        // System.out.println(al);
        
        int[][] arr = new int[m][n];
        
        int tle = m * n;
        int sr = 0, sc = 0;
        int er = m - 1;
        int ec = n - 1;
        int dir = -1;
        
        while(tle != 0){
            dir = (dir + 1) % 4;
            
            if(dir==0){
                for(int i=sc; i<=ec; i++){
                    arr[sr][i] = al.get(ind);
                    ind++;
                    tle--;
                }
                sr++;
            }
            
            else if(dir==1){
                for(int i=sr; i<=er; i++){
                    arr[i][ec] = al.get(ind);
                    ind++;
                    tle--;  
                }
                ec--;
            }
            
            else if(dir==2){
                for(int i=ec; i>=sc; i--){
                    arr[er][i] = al.get(ind);
                    ind++;
                    tle--;
                }
                er--;
            }
            
            else{
                for(int i=er; i>=sr; i--){
                    arr[i][sc] = al.get(ind);
                    ind++;
                    tle--;
                }
                sc++;   
            }
        }       
        
        return arr;
        
    }

}
