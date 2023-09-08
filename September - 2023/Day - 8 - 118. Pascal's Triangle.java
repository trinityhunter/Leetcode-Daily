class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ma = new ArrayList<>();

        List<Integer> ca = new ArrayList<>();

        ca.add(1);

        ma.add(ca);

        if(numRows == 1){
            return ma;
        }

        for(int i=1; i<numRows; i++){
            ca = new ArrayList<>();
            ca.add(1);
            for(int j=0; j<ma.get(ma.size()-1).size()-1; j++){
                ca.add(ma.get(ma.size()-1).get(j) + ma.get(ma.size()-1).get(j+1));
            }
            ca.add(1);
            ma.add(ca);
        }

        return ma;

    }

}
