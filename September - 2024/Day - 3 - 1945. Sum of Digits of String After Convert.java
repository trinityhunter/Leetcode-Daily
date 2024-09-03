class Solution {

    public int getLucky(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i)-'a'+1);
        }  
        
        System.out.println(sb);
        
        int sum = 0;
        
        while(k != 0){
            
            // System.out.println(sb);
            
            sum = 0;
            
            for(int i=0; i<sb.length(); i++){
                sum += sb.charAt(i) - '0';
            } 
            
            sb.delete(0, sb.length());
            
            sb.append(sum);
            
            k--;
            
        }
        
        return sum;
        
    }
    
}
