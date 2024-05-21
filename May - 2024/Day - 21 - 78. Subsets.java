class Solution {

    public static void helper(int[] nums, int ind){

        if(ind == nums.length){
            ma.add(new ArrayList<>(ca));
            return;
        }

        helper(nums, ind+1);

        ca.add(nums[ind]);
        helper(nums, ind+1);
        ca.remove(ca.size()-1);

    }

    public static List<List<Integer>> ma = new ArrayList<>();

    public static List<Integer> ca = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        ma = new ArrayList<>();

        ca = new ArrayList<>();

        helper(nums, 0);

        return ma;

    }

}
