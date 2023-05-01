class Solution {

    public double average(int[] salary) {
        
        double sum = 0;

        double max = Double.MIN_VALUE;

        double min = Double.MAX_VALUE;

        for(int i=0; i<salary.length; i++){

            sum += salary[i];

            min = Math.min(min, salary[i]);

            max = Math.max(max, salary[i]);
            
        }

        sum -= min;

        sum -= max;

        return sum/(salary.length-2);

    }

}
