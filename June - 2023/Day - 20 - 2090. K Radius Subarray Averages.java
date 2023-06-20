class Solution {

    public int[] getAverages(int[] nums, int k) {
        
        int window = 2*k+1;

        long sum = 0;

        if(window>nums.length){
            int[] temp = new int[nums.length];
            Arrays.fill(temp, -1);
            return temp;
        }

        for(int i=0; i<window; i++){
            sum += nums[i];
        }

        List<Integer> arr = new ArrayList<>();

        arr.add((int)(sum/window));

        for(int i=window; i<nums.length; i++){

            sum -= nums[i-window];
            sum += nums[i];

            arr.add((int)(sum/window));

        }

        int[] ans = new int[nums.length];

        int ind = 0;

        for(int i=0; i<k; i++){
            ans[i] = -1;
        }

        for(int i=k; i<nums.length-k; i++){
            ans[i] = arr.get(ind);
            ind++;
        }

        for(int i=nums.length-k; i<nums.length; i++){
            ans[i] = -1;
        }

        // System.out.println(arr);

        return ans;

    }

}
