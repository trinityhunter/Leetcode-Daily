class Solution {
    
    public int countSeniors(String[] details) {
        
        int count=0;
        
        int age;

        String s;

        for(int i=0; i<details.length; i++){

            age = 10*(details[i].charAt(11) - 48) + (details[i].charAt(12) - 48);

            if(age>60){
                count++;
            }

        } 
        
        return count;

    }
    
}
