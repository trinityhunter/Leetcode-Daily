class Solution {

    public static int binarySearch(ArrayList<Integer>list, int low, int high, int key){

        int ans = high;

        while(low<=high){

            int mid = (low+high)/2;

            if(list.get(mid)>key){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }

        }

        return ans;

    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int dp[] = new int[obstacles.length];

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<obstacles.length; i++){

            if(arr.size() == 0 || arr.get(arr.size()-1) <= obstacles[i]){
                
                arr.add(obstacles[i]);
                dp[i] = arr.size();

            }
            else{

                int idx = binarySearch(arr, 0, arr.size(), obstacles[i]);

                if(idx == arr.size()){
                    arr.add(obstacles[i]);
                }
                else{
                    arr.set(idx, obstacles[i]);
                }

                dp[i] = idx+1;

            }

        }

        return dp;

    }

}
