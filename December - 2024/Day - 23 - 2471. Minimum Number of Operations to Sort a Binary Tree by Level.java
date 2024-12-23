/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static int notInplace(List<Integer> arr){

        int swaps = 0;

        int[] sorted = new int[arr.size()];

        for(int i=0; i<sorted.length; i++){
            sorted[i] = arr.get(i);
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.size(); i++){
            hm.put(arr.get(i), i);
        }
        
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) != sorted[i]) {
                swaps++;
                hm.put(arr.get(i), hm.get(sorted[i]));
                arr.set(hm.get(sorted[i]), arr.get(i));
            }
        }

        return swaps;

    }

    public static void helper(TreeNode node){

        if(node == null){
            return;
        }

        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(node);

        while(q.size()>0){
            int count = q.size();

            for(int i=0; i<count; i++){
                TreeNode rem = q.remove();

                ca.add(rem.val);

                if(rem.left!=null){
                    q.add(rem.left);
                }

                if(rem.right!=null){
                    q.add(rem.right);
                }

            }

            ans += notInplace(ca);
            
            ca = new ArrayList<>();

        }

    }

    public static List<Integer> ca;

    public static int ans;

    public int minimumOperations(TreeNode root) {
        
        ca = new ArrayList<>();

        ans = 0;

        helper(root);

        return ans;

    }

}
