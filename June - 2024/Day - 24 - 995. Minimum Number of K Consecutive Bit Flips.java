class Solution {

    public int minKBitFlips(int[] nums, int k) {

        int ans = 0;
        
        int ind = 0;

        ArrayList<Integer> al = new ArrayList<>();

        boolean state = true;

        for(int i=0; i<nums.length; i++){

            if(ind<al.size() && i==al.get(ind)){
                ind++;
                state=!state;
            }

            if((nums[i]==0 && state) || (!state&&nums[i]==1)){
                if(i+k>nums.length){
                    return -1;
                }
                al.add(i+k);
            }

            if(state){
                if(nums[i]==0){
                    ans = -(~ans);
                    state = !state;
                }
            }
            else{
                if(nums[i]==1){
                    state = !state;
                    ans = -(~ans);
                }
            } 
              
        }

        return ans;

    }

}
