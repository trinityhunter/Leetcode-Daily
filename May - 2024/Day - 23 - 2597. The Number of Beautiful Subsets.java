class Solution {

    public int beautifulSubsets(int[] nums, int k) {

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), nums, 0, k);

        return list.size();

    }

    public void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start, int k) {

        if (!templist.isEmpty()) {
            list.add(new ArrayList<>(templist)); 
        }

        for (int i = start; i < nums.length; i++) {
            if(templist.contains(nums[i] - k))
                continue;
            templist.add(nums[i]);

            backtrack(list, templist, nums, i+1, k);

            templist.remove(templist.size() - 1); 
        }

    }
    
}
