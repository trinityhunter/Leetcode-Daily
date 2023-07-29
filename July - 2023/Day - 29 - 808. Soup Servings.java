class Solution {

    public static double helper(int a, int b){

        if(a <= 0 && b <= 0){
            return 0.5;
        }

        if(a <= 0){
            return 1.0;
        }

        if(b <= 0){
            return 0.0;
        }

        Pair<Integer, Integer> key = new Pair<>(a, b);

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        dp.put(key, 0.25 * (helper(a-4, b) + helper(a-3, b-1) + helper(a-2, b-2) + helper(a-1, b-3)));

        return dp.get(key);

    }

    public static HashMap<Pair<Integer, Integer>, Double> dp;

    public double soupServings(int n) {

        if(n > 4800){
            return 1.0;
        }

        dp = new HashMap<>();

        n = (n+24)/25;

        double ans = helper(n, n);

        return ans;

    }

}
