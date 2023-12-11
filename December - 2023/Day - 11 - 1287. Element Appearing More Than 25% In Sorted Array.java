class Solution {

    public int findSpecialInteger(int[] arr) {

        int m = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] == arr[i]){
                m += 1;
                if(m > (arr.length/4)){
                    return arr[i];
                }
            }
            else{
                m = 1;
            }
        }

        return arr[arr.length-1];

    }

}
