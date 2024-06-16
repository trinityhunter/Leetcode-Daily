class Solution {

    public int minPatches(int[] nums, int n) {

        long lowestSumUnattainable = 1;
        
        int numbersToAdd = 0;

        int index = 0;

        while(lowestSumUnattainable <= n){

            if(index < nums.length && nums[index] <= lowestSumUnattainable){
                lowestSumUnattainable += nums[index];
                index++;
            } 
            else{
                lowestSumUnattainable += lowestSumUnattainable;
                numbersToAdd++;
            }

        }

        return numbersToAdd;

    }
    
}
