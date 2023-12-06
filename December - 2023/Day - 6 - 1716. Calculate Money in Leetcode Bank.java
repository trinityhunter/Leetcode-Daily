class Solution {

    public int totalMoney(int n) {

        int sum = 0;

        int[] arr = new int[7];

        for(int i=0; i<7; i++){
            arr[i] = i+1;
        }

        int t = (n/7)+1;

        while(t-->0){
            for(int i=0; i<7 && i<n; i++){
                sum += arr[i];
                arr[i]++;
            }
            n=n-7;
        }

        return sum;

    }
    
}
