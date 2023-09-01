class Solution {

    public static void helper(int[] arr, int num, int n){

        if(num>n){
            return;
        }

        String str = Integer.toBinaryString(num);

        int count = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }

        arr[num] = count;

        helper(arr, num+1, n);

    }

    public int[] countBits(int n) {
        
        int[] arr = new int[n+1];

        helper(arr, 0, n);

        return arr;

    }
  
}
