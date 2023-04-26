class Solution {
    
    public int addDigits(int num) {
        
        String str = num + "";
        
        if(str.length() == 1){
            return num;
        }
        
        while(str.length()!=1){
            
            int temp = 0;
            
            for(int i=0; i<str.length(); i++){
                temp += str.charAt(i) - '0';
            }
            
            str = temp + "";
            
        }
        
        return Integer.parseInt(str);
        
    }

}
