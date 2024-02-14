class Solution {

    public int[] rearrangeArray(int[] nums) {
        
        List<Integer> pos = new ArrayList<>();

        List<Integer> neg = new ArrayList<>();

        int ind = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        int[] arr = new int[nums.length];

        int i = 0;

        int j = 0;

        while(ind<nums.length){
            arr[ind] = pos.get(i);
            i++;
            ind++;
            arr[ind] = neg.get(j);
            j++;
            ind++;
        }

        return arr;

    }  

}
