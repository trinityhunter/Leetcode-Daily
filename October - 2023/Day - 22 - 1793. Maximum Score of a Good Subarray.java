class Solution {

    public int maximumScore(int[] nums, int k) {

        int n = nums.length;

        int best[] = new int[n];

        Arrays.fill(best,-1);

        best[k] = nums[k];

        int i = k-1;

        while(i>=0){
            best[i] = Math.min(nums[i],best[i+1]);
            i-=1;
        }

        i = k+1;

        while(i<n){
            best[i] = Math.min(nums[i],best[i-1]);
            i+=1;
        }

        int ans = best[k];
        
        int min = ans;

        int j=k+1;

        i = k-1;

        while(i>=0 || j<n){

            if(i<0){
                min = Math.min(min,best[j]);
                ans = Math.max(ans,min*(j-i));
                j+=1;
                continue;
            }

            if(j==n){
                min = Math.min(min,best[i]);
                ans = Math.max(ans,min*(j-i));
                i-=1;
                continue;
            }

            if(best[j]>=best[i]){
                min = Math.min(min,best[j]);
                ans = Math.max(ans,min*(j-i));
                j+=1;
            } 
            else{
                min = Math.min(min,best[i]);
                ans = Math.max(ans,min*(j-i));
                i-=1;
            }

        }

        return ans;

    }
    
}
