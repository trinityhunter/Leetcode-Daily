class Solution {

    public static void helper(String[] arr, int ind, int size){

        if(size == 0){
            ma.add(new String(sb.toString()));
            return;
        }

        if(ind == arr.length){
            return;
        }

        helper(arr, ind+1, size);

        sb.append(arr[ind]);
        helper(arr, ind, size-1);
        sb.deleteCharAt(sb.length()-1);

    }

    public static List<String> ma;

    public static StringBuilder sb;

    public String findDifferentBinaryString(String[] nums) {
        
        ma = new ArrayList<>();

        sb = new StringBuilder();

        String[] arr = {"0", "1"};

        helper(arr, 0, nums.length);

        for(int i=0; i<nums.length; i++){
            ma.remove(nums[i]);
        }

        return ma.get(0);

    }

}
