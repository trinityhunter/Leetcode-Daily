class Solution {

    public static int helper(int[] nums1, int[] nums2, int idx1, int idx2) {

        if(idx1 == nums1Size || idx2 == nums2Size){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        int option1 = nums1[idx1] * nums2[idx2] + helper(nums1, nums2, idx1 + 1, idx2 + 1);

        int option2 = helper(nums1, nums2, idx1, idx2 + 1);

        int option3 = helper(nums1, nums2, idx1 + 1, idx2);

        dp[idx1][idx2] = Math.max(Math.max(option1, option2), option3);

        return dp[idx1][idx2];
        
    }

    public static int[][] dp;

    public static int nums1Size;
    
    public static int nums2Size;
    
    public int maxDotProduct(int[] nums1, int[] nums2) {

        dp = new int[505][505];

        nums1Size = nums1.length;

        nums2Size = nums2.length;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int num: nums1){
            max1 = Math.max(max1, num);
            min1 = Math.min(min1, num);
        }
        
        for(int num: nums2){
            max2 = Math.max(max2, num);
            min2 = Math.min(min2, num);
        }
        
        if((max1<0 && min2>0) || (min1>0 && max2<0)){
            return Math.max(max1 * min2, min1 * max2);
        }
        
        for(int i=0; i<505; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(nums1, nums2, 0, 0);

    }

}
