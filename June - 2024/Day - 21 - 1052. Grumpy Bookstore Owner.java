class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
       
       int sum = 0;

        for(int i=0; i<customers.length; i++){
            if(grumpy[i] == 0){
                sum += customers[i];
                customers[i] = 0;
            }
        }
       
       int secondsum = 0;

       int i = 0;

        for(;i<minutes;i++){
            secondsum+=customers[i];
        }

        int j = 0;

        int max = secondsum;

        for(;i<customers.length;i++){
            secondsum += customers[i];
            secondsum -= customers[j];
            max = Math.max(secondsum, max);
            j++;
        }
     
        return sum+max;

    }
    
}
