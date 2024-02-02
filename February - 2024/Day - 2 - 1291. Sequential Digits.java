class Solution {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> output = new ArrayList<>();

        String s = "123456789";

        for(int i = 0; i<9; i++){
            for(int j = i+1; j<=9; j++){
                int cur = Integer.parseInt(s.substring(i, j));

                if(cur >= low && cur <= high){
                    output.add(cur);
                }
            }
        }

        Collections.sort(output);

        return output;

    }
    
}
