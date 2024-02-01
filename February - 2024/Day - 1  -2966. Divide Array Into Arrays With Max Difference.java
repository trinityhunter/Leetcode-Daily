class Solution {

    public int[][] divideArray(int[] nums, int k) {

        Arrays.sort(nums);

        int idx = 0;

        int[][] ans = new int[nums.length / 3][3];

        for(int i=0; i<nums.length; i=i+3){
            int[] arr = new int[3];
            for(int j=0; j<3; j++){
                arr[j] = nums[i + j];
            }
            ans[idx++] = arr;
        }

        for(int i=0; i<ans.length; i++){
            if(ans[i][2] - ans[i][0]>k){
                return new int[0][0];
            }
        }

        return ans;

    }
    
}
