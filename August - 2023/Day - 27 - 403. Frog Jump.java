class Solution {

    public static boolean helper(HashSet<Integer> set, int val, int k, int last){

        if(val == last){
            return true;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(val);
        sb.append(" ");
        sb.append(k);

        if(dp.containsKey(sb.toString())){
            return dp.get(sb.toString());
        }

        for(int i=k-1; i<=k+1; i++){
            if(i>0 && set.contains(val+i) && helper(set, val+i, i, last)){
                dp.put(sb.toString(), true);
                return true;
            }
        }

        dp.put(sb.toString(), false);

        return false;

    }

    public static HashMap<String, Boolean> dp;

    public boolean canCross(int[] stones) {

        // ***** Memoization ***** - 

        if(stones[1] > 1){
            return false;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<stones.length; i++){
            set.add(stones[i]);
        }

        dp = new HashMap<>();
        
        boolean ans = helper(set, stones[1], 1, stones[stones.length-1]);

        return ans;

    }

}
