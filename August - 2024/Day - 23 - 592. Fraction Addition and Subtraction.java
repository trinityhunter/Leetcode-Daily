class Solution {

    public String fractionAddition(String expression) {

        String[] nums = expression.split("/|(?=[+-])");

        int lcm = 1;

        for(int i=1; i<nums.length; i+=2){
            lcm = calculateLCM(lcm, Integer.parseInt(nums[i]));
        }

        int sum = 0;

        for(int i=0; i<nums.length; i+=2){
            sum += Integer.parseInt(nums[i]) * (lcm / Integer.parseInt(nums[i + 1]));
        }

        int divisor = gcd(Math.abs(sum), lcm);

        sum /= divisor;
        lcm /= divisor;

        return sum + "/" + lcm;

    }

    private int calculateLCM(int a, int b){

        return Math.abs(a * b) / gcd(a, b);

    }

    private int gcd(int a, int b){

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;

    }
    
}
