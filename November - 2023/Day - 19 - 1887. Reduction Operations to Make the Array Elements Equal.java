class Solution {

    public int reductionOperations(int[] arr) {

        Arrays.sort(arr);

        int total = 0;

        int curr = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                curr++;
            }
            total += curr;
        }

        return total;

    }

}
