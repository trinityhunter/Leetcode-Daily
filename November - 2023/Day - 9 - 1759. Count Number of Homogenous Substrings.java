class Solution {

    public int countHomogenous(String s) {

        int n = s.length();

        long cc = 0;

        long ans = 0;

        for(int i=0; i<n; i++){

            if(i==0){
                cc++;
            }
            else {
                if(s.charAt(i)!=s.charAt(i-1)) {
                    ans += (cc * (cc + 1)) / 2;
                    cc = 1;
                }
                else {
                    cc++;
                }
            }
        }

        ans += (cc*(cc+1))/2;

        ans = ans % 1000000007;
       
        return (int)ans;
 
    }
    
}
