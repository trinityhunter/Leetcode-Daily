class Solution {

    public int passThePillow(int n, int time) {

        if(n == time+1){
            return n;
        }

        if(n > time){
            return time+1;
        }

        if(n == time){
            return n-1;
        }

        int i = 1;

        while((n-1)*i<=time){
            i++;
        }

        i = i-1;

        if(i==time){
            if(i%2 == 1){
                return n;
            }
            else{
                return n-1;
            }
        }

        if((n-1) * i == time){
            if(i%2 == 1){
                return n;
            }
            else{
                return 1;
            }
        } 

        if(i%2 == 0){
            return time-(n-1)*i+1;
        }
        else{
            int r = time-(n-1)*i;
            return n-r;
        }

    }
    
}
