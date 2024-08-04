class Solution {

    public int rangeSum(int[] nums, int n, int left, int right) {

        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;

        for(int i=0; i<nums.length; i++){

            sum = nums[i];

            list.add(nums[i]);

            for(int j=i+1; j<n; j++){
                sum += nums[j]; 
                list.add(sum); 
            }

        }

        Collections.sort(list);
        
        sum = 0;

        for(int l=left-1; l<right; l++){
            
            sum = (sum + list.get(l))%1000000007;
           
        }
     
        return sum;

    }
    
}
