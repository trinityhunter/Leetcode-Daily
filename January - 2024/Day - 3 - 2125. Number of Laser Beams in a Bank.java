class Solution {
    
    public static int numberOfOnesIn(String str){
        
        int count = 0;
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                count++;
            }
        }
        
        return count;

    }
    
    public int numberOfBeams(String[] bank) {
        
        ArrayList<String> arr1 = new ArrayList<String>();
        
        for(int i=0; i<bank.length; i++){
            int num = 0;
            for(int j=0; j<bank[0].length(); j++){
                num += bank[i].charAt(j) - '0';
            }
            if(num > 0){
                arr1.add(bank[i]);
            }
        }
        
        String [] arr = new String [arr1.size()];
        
        for(int i=0; i<arr1.size(); i++){
            arr[i] = arr1.get(i);
        }
        
        int ans = 0;
        
        for(int i=0, j=1; i<arr.length && j<arr.length; i++, j++){
            ans += numberOfOnesIn(arr[i]) * numberOfOnesIn(arr[j]);
        }
        
        return ans;

    }
    
}
