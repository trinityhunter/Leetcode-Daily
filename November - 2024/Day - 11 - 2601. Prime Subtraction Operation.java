class Solution {

    public boolean primeSubOperation(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int idx = 1;

        while(idx<1005){

            if(isBoolean(idx)){

                list.add(idx);

            }

            idx++;

        }

        int n = list.size();
        
        for(int i=nums.length-2; i>=0; i--){

            if(nums[i] >= nums[i+1]){

                int j = 0;

                while(j<n && list.get(j)<nums[i] && nums[i]-list.get(j) >= nums[i+1]){
                    j++;
                }

                if(j<n && list.get(j)<nums[i]){
                    nums[i] -= list.get(j);
                }

                if(j==n || nums[i]>=nums[i+1]){
                    return false;
                }

            }
                
        }

        return true;

    }

    private boolean isBoolean(int x){

        if(x == 1){
            return false;
        }

        for(int i=2; i<x; i++){
            if(x%i==0){
                return false;
            }
        }

        return true;

    }
    
}
