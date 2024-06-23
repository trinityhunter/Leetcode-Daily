class Solution {

    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxi = new ArrayDeque();

        Deque<Integer> mini = new ArrayDeque();

        int i = 0;
        
        int j = 0;

        int max = 0;

        while(j < nums.length){

            while(!maxi.isEmpty() && nums[maxi.peekLast()] <= nums[j]){
                maxi.pollLast();
            }

            while(!mini.isEmpty() && nums[mini.peekLast()] >= nums[j]){
                mini.pollLast();
            }

            maxi.offerLast(j);
            mini.offerLast(j);

            while(nums[maxi.peekFirst()] - nums[mini.peekFirst()] > limit){

                if(mini.peekFirst() == i){
                    mini.pollFirst();
                }
                
                if(maxi.peekFirst() == i){
                    maxi.pollFirst();
                }

                i++;

            }

            max = Math.max(max, j - i + 1);

            j++;

        }

        return max;

    }

}
