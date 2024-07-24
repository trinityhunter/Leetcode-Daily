class Solution {
   
    public int[] sortJumbled(int[] mapping, int[] nums) {

        Integer[] numsArray = new Integer[nums.length];

        for(int i=0; i<nums.length; i++){
            numsArray[i] = nums[i];
        }
        
        Arrays.sort(numsArray, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int mappedA = mapValue(a, mapping);
                int mappedB = mapValue(b, mapping);
                return Integer.compare(mappedA, mappedB);
            }
        });
        
        for(int i=0; i<nums.length; i++){
            nums[i] = numsArray[i];
        }

        return nums;

    }
    
    private int mapValue(int num, int[] mapping){

        StringBuilder mapped = new StringBuilder();

        String numStr = String.valueOf(num);

        for(char digit : numStr.toCharArray()){
            mapped.append(mapping[digit - '0']);
        }

        return Integer.parseInt(mapped.toString());
        
    }

}
