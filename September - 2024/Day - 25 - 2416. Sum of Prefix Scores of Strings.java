class Solution {

    class TrieNode {

        TrieNode child[];

        int ct;

        TrieNode(){
            child = new TrieNode[26];
            ct = 0;
        }

    }

    private void add(TrieNode root, String str) {

        int n = str.length();

        for(int i=0; i<n; i++){

            int idx = (str.charAt(i)-'a');

            if(root.child[idx] == null) {
                root.child[idx] = new TrieNode();
            }

            root = root.child[idx];

            root.ct++;

        }

    }

    private int findSum(TrieNode root, String str){

        int n = str.length();
        
        int sum = 0;

        for(int i=0; i<n; i++){
            int idx = (str.charAt(i)-'a');
            root = root.child[idx];
            sum += root.ct;
        }

        return sum;

    }

    public int[] sumPrefixScores(String[] words) {

        int n = words.length;

        TrieNode root = new TrieNode();

        for(int i=0; i<n; i++) {
            add(root, words[i]);
        }

        int res[] = new int[n];

        for(int i=0; i<n; i++) {
            res[i] = findSum(root, words[i]);
        }

        return res;
        
    }
    
}
