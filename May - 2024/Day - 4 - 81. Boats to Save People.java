class Solution {

    public int numRescueBoats(int[] people, int limit) {

        int count = 0;

        Arrays.sort(people);
        
        int low = 0;

        int high = people.length - 1;
        
        while(low <= high){

            int sum = people[low] + people[high];

            if(sum <= limit){
                count++;
                low++;
                high--;
            }
            else{
                count++;
                high--;
            }

        }

        return count;

    }

}
