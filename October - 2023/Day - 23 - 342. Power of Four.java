class Solution {

    public boolean isPowerOfFour(int n) {

        if(n == 1){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(n%4 == 0){
            while(n/4 != 1){
                if(n%4 != 0){
                    break;
                }
                n = n/4;
            }
        }

        if(n%4 != 0){
            return false;
        }

        return true;

    }

}
