public class Solution {

    public int nthUglyNumber(int n) {

        int[] arr = new int[n];

        int[] nums = {2,3,5};

        int[] ind = new int[nums.length];

        arr[0]=1;

        for(int i=1;i<n;i++){
            arr[i] = Integer.MAX_VALUE;

            for(int j=0;j<nums.length;j++){
                arr[i] = Math.min(arr[i], nums[j] * arr[ind[j]]);
            }

            for(int j=0;j<nums.length;j++){
                if(arr[i] == nums[j] * arr[ind[j]]){
                    ind[j]++;
                }
            }

        }

        return arr[n-1];

    }

}
