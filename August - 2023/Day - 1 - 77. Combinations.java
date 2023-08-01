class Solution {

    public static void helper(int n, int ind, int size){

        if(size == 0){
            ma.add(new ArrayList<>(ca));
            return;
        }

        if(ind == n+1){
            return;
        }

        helper(n, ind+1, size);

        ca.add(ind);
        helper(n, ind+1, size-1);
        ca.remove(ca.size()-1);

    }

    public static List<List<Integer>> ma;

    public static List<Integer> ca;

    public List<List<Integer>> combine(int n, int k) {
        
        ma = new ArrayList<>();

        ca = new ArrayList<>();

        helper(n, 1, k);

        return ma;

    }

}
