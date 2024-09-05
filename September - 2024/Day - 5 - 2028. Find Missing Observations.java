class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {

        int sum = 0;

        for(int i=0; i<rolls.length; i++){

            sum += rolls[i];

        }

        int remainingsum = (mean * ( n + rolls.length)) - sum;

        if(remainingsum > 6 * n || remainingsum < n){
            return new int[0];
        }

        int distributedmean = remainingsum/n;

        int mod = remainingsum % n;

        int arr[] = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = distributedmean;
        }

        for(int i=0; i<mod; i++){
            arr[i]++;
        }

        return arr;

    }
    
}
