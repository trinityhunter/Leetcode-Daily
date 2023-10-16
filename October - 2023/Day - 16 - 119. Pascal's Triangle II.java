class Solution {

    public List<Integer> getRow(int n) {
        
        List<Integer> arr = new ArrayList<>();

        arr.add(1);

        if(n == 0){
            return arr;
        }

        arr.add(1);

        if(n == 1){
            return arr;
        }

        for(int i=2; i<=n; i++){
            List<Integer> temp = new ArrayList<>();

            temp.add(1);

            for(int j=1; j<arr.size(); j++){
                temp.add(arr.get(j-1) + arr.get(j));
            }

            temp.add(1);

            arr = temp;
        }

        return arr;

    }

}
