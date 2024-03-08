class Solution {

    public int maxFrequencyElements(int[] nums) {

        int maxNum = 0;

        for(int n: nums){
            maxNum = Math.max(maxNum, n);
        }

        int freq[] = new int[maxNum+1];
        
        int max = 0;

        for(int n: nums){
            freq[n]++;
            max = Math.max(max, freq[n]);
        }

        int ans = 0;

        for(int i=1; i<maxNum+1; i++){
            if(max == freq[i]){
                ans += freq[i];
            }
        }

        return ans;

    }

}
