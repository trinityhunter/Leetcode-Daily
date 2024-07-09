class Solution {

    public double averageWaitingTime(int[][] customers) {

        int time = customers[0][0];

        long waitingTime = 0;

        for(int i=0; i<customers.length; i++){

            if(customers[i][0] > time){
                time = customers[i][0];
            }

            time += customers[i][1];

            waitingTime += (time - customers[i][0]);

        }

        return (double)waitingTime / customers.length;

    
}
