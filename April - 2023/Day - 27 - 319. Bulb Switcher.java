class Solution {

    public int bulbSwitch(int n) {
      
        // Brute Force - 
        
        // int[] arr = new int[n+1];

        // for(int i=1; i<=n; i++){
        //     for(int j=0; j<arr.length; j++){
        //         if((j+1)%i == 0){
        //             if(arr[j] == 0){
        //                 arr[j] = 1;
        //             }
        //             else{
        //                 arr[j] = 0;
        //             }
        //         }
        //     }
        // }

        // int ans = 0;

        // for(int i=0; i<arr.length; i++){
        //     if(arr[i] == 1){
        //         ans++;
        //     }
        // }

        // if(ans == 0){
        //     return
        // }

        // return ans-1;

        return (int)Math.sqrt(n);

    }

}
