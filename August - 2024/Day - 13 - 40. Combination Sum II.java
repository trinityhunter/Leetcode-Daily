class Solution {
    
    public static void helper(int[] candidates, int ind, int target){

        if(target == 0){
            ma.add(new ArrayList(ca));
            return;
        }
        
        if(ind == candidates.length || candidates[ind] > target){
            return;
        }
        
        ca.add(candidates[ind]);

        helper(candidates, ind+1, target-candidates[ind]);

        while(ind < candidates.length-1 && candidates[ind] == candidates[ind+1]){
            ind++;
        }

        ca.remove(ca.size()-1);

        helper(candidates, ind+1, target);
            
    }

    public static List<List<Integer>> ma;

    public static List<Integer> ca;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        ma = new ArrayList<>();

        ca = new ArrayList<>();

        Arrays.sort(candidates);

        helper(candidates, 0, target);

        return ma;

    }
    
}
