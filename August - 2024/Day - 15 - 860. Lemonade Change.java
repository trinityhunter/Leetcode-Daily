class Solution {

    public boolean lemonadeChange(int[] bills) {

        int[] arr = {0, 0};

        for(int i: bills){

            if(i != 20){
                arr[i/5 - 1]++;
            }
            
            int change = i - 5;

            while(change != 0){

                if(change >= 10 && arr[1] != 0){
                    change -= 10;
                    arr[1]--;
                }
                else if(change >= 5 && arr[0] != 0){
                    change -= 5;
                    arr[0]--;
                }
                else{
                    return false;
                }

            }

        }

        return true;

    }
    
}
