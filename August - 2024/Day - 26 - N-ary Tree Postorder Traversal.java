/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public static void helper(Node node){
        if(node == null){
            return;
        }
        
        for(int i=0; i<node.children.size(); i++){
            helper(node.children.get(i));
        }
        
        arr.add(node.val);
    }
    
    public static List<Integer> arr = new ArrayList<>();
    
    public List<Integer> postorder(Node root) {
        
        arr = new ArrayList<>();
        
        helper(root);
        
        return arr;
        
    }
}
