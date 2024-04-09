class Solution {
    
    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;

        for(int i=0; i<tickets.length; i++){
            if(tickets[k] > tickets[i]){
                time += tickets[i];
            }
            else{
                time += tickets[k];
                if(i>k){
                    time--;
                }
            }
        }

        return time;
        
    }

}
