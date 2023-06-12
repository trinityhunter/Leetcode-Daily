class Solution {

    public List<String> summaryRanges(int[] nums) {
        
        List<String> arr = new ArrayList();

        if(nums.length == 1){
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]);
            arr.add(sb.toString());
            return arr;
        }

        for(int i=0; i<nums.length; i++){

            int a = nums[i];

            while(i+1 < nums.length && (nums[i+1] - nums[i]) == 1){
                i++;
            }

            StringBuilder sb = new StringBuilder();

            if(a != nums[i]){
                sb.append(a);
                sb.append("->");
                sb.append(nums[i]);
                arr.add(sb.toString());
            }
            else{
                sb.append(a);
                arr.add(sb.toString());
            }

        }

        return arr;

    }

}
