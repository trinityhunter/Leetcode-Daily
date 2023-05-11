class Solution {

    public static int helper(int[] arr1, int[] arr2, int n1, int n2){

        if(n1 == 0 || n2 == 0){
            return 0;
        }

        if(dp[n1][n2]!=null){
            return dp[n1][n2];
        }

        if(arr1[n1 - 1] == arr2[n2 - 1]){
            dp[n1][n2] = 1 + helper(arr1, arr2, n1 - 1, n2 - 1);
        }
        else{
            dp[n1][n2] = Math.max(helper(arr1, arr2, n1 - 1, n2), helper(arr1, arr2, n1, n2 - 1));
        }

        return dp[n1][n2];

    }

    public static Integer[][] dp;

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        dp = new Integer[nums1.length+1][nums2.length+1];
        
        return helper(nums1, nums2, nums1.length, nums2.length);

    }

}
