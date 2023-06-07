class Solution {

    public static int[] helper(int n){

        int[] arr = new int[32];
        
        int i = 0;

        while(n > 0){

            arr[i] = n % 2;
            n /= 2;
            i++;

        }
        
        return arr;

    }

    public int minFlips(int a, int b, int c) {

        int[] a1 = helper(a);

        int[] b1 = helper(b);

        int[] c1 = helper(c);
        
        int ans = 0;     
        
        int i = 0;

        while(i < 32){

            if(c1[i]==1 && (a1[i]==0 && b1[i]==0)){
                ans++;
            }
            else if(c1[i]==0 && (a1[i]==1 && b1[i]==1)){
                ans += 2;
            }
            else if(c1[i]==0 && (a1[i]==1 || b1[i]==1)){
                ans++;
            }

            i++;

        }
        
        return ans;

    }

}
