class Solution {

    public static int helper2(int[] rating, int ind, int prev, int count){

        if(count == 0){
            return 1;
        }

        if(ind == rating.length){
            return 0;
        }

        if(dp2[ind][prev+1][count]!=null){
            return dp2[ind][prev+1][count];
        }

        int notPick = helper2(rating, ind+1, prev, count);

        int pick = 0;

        if(prev == -1 || rating[ind]<rating[prev]){
            pick = helper2(rating, ind+1, ind, count-1);
        }

        return dp2[ind][prev+1][count] = pick + notPick;

    }

    public static int helper1(int[] rating, int ind, int prev, int count){

        if(count == 0){
            return 1;
        }

        if(ind == rating.length){
            return 0;
        }

        if(dp1[ind][prev+1][count]!=null){
            return dp1[ind][prev+1][count];
        }

        int notPick = helper1(rating, ind+1, prev, count);

        int pick = 0;

        if(prev == -1 || rating[ind]>rating[prev]){
            pick = helper1(rating, ind+1, ind, count-1);
        }

        return dp1[ind][prev+1][count] = pick + notPick;

    }

    public static Integer[][][] dp1;

    public static Integer[][][] dp2;

    public int numTeams(int[] rating) {

        dp1 = new Integer[rating.length][rating.length+1][4];
        
        int ans1 = helper1(rating, 0, -1, 3);

        dp2 = new Integer[rating.length][rating.length+1][4];

        int ans2 = helper2(rating, 0, -1, 3);

        return ans1+ans2;

    }

}
