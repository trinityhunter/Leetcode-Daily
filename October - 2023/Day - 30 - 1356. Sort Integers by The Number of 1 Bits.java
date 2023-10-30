class Solution {

    public int[] sortByBits(int[] arr) {
        
        Arrays.sort(arr);
        
        int[] arr1 = new int[arr.length];
        
        int max = 0;
        
        for(int i=0; i<arr.length; i++){
            String str = Integer.toBinaryString(arr[i]);
            
            int ones = 0;
            
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '1'){
                    ones++;
                }
            }
            
            arr1[i] = ones;
            max = Math.max(max, arr1[i]);
        }
        
        int[] arr2 = new int[arr.length];
        
        int ind = 0;
        
        for(int i=0; i<=max; i++){
            for(int j=0; j<arr.length; j++){
                if(arr1[j] == i){
                    arr2[ind] = arr[j];
                    ind++;
                }
            }
        }
        
        return arr2;

    }
    
}
