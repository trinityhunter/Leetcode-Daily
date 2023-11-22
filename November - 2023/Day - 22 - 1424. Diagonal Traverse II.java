class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<List<Integer>> temp = new ArrayList<>();

        int count = 0;

        for(int i=0; i<nums.size(); i++){
            int sz = nums.get(i).size();
            for(int j=0;j<sz;j++){
                if(temp.size() <= i+j){
                    temp.add(new ArrayList<>());
                }
                List<Integer> ref = temp.get(i+j);
                ref.add(nums.get(i).get(j));
                count++;
            }
        }
        
        int[] ans  = new int[count];

        int ind = 0;

        for(int i=0; i<temp.size(); i++){
            for(int j=temp.get(i).size()-1; j>=0; j--){
                ans[ind++] = temp.get(i).get(j);
            }
        }

        return ans;

    }

}
