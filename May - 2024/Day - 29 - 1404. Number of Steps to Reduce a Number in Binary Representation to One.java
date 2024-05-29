import java.math.BigInteger;

class Solution {

    public int numSteps(String s) {

        BigInteger num = new BigInteger(s, 2);

        int count = 0;

        while(!num.equals(BigInteger.ONE)){

            if(num.testBit(0)){
                num = num.add(BigInteger.ONE);
            }
            else{
                num = num.shiftRight(1);
            }

            count++;

        }

        return count;

    }
    
}
